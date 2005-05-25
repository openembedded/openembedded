/* vi: set sw=4 ts=4: */
/*
 * devio: correctly read a region of a device
 *
 * A dd like program designed to read correctly from mtd character
 * (and maybe block) devices.  Allows access to specific regions
 * of the device and allows output of numbers from specific locations.
 *
 * Copyright (C) 2005 John Bowler <jbowler@acm.org>
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation files
 * (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify,
 * merge, publish, distribute, sublicense, and/or sell copies of the
 * Software, and to permit persons to whom the Software is furnished
 * to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <limits.h>
#include <errno.h>

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>

#ifndef S_ISSOCK
#define S_ISSOCK(fd) 0
#endif

/* Define to 0 to remove the detailed help. */
#ifndef HELP
#define HELP 1
#endif

#ifndef STR_MAX
#define STR_MAX 4096
#endif

/* common error-and-die functions - reduces code size slightly. */
static int error_level = 1; /* Increased by write operations. */

/* NDEBUG will only save about 600 bytes! */
/* The noreturn attribute helps reduce size by 300 bytes, and removes
 * warning messages
 */
#if NDEBUG
static void do_die(const unsigned char *why) __attribute__((noreturn));
static void do_die(const unsigned char *why) {
	fprintf(stderr, "devio: %s\n", why);
	exit(error_level);
}
#define die(a,b) do_die(a)
#else
static void do_die(const unsigned char *why, const unsigned char *infile)
    __attribute__((noreturn));
static void do_die(const unsigned char *why, const unsigned char *infile) {
	fprintf(stderr, "devio: %s: %s\n", infile, why);
	exit(error_level);
}
#define die(a,b) do_die((a),(b))
#endif

#if NDEBUG
static void do_pdie(const unsigned char *why) __attribute__((noreturn));
static void do_pdie(const unsigned char *why) {
	fprintf(stderr, "devio: %s: %s\n", why, strerror(errno));
	exit(error_level);
}
#define pdie(a,b) do_pdie(a)
#else
static void do_pdie(const unsigned char *why, const unsigned char *infile)
    __attribute__((noreturn));
static void do_pdie(const unsigned char *why, const unsigned char *infile) {
	fprintf(stderr, "devio: %s: %s: %s\n", infile, why, strerror(errno));
	exit(error_level);
}
#define pdie(a,b) do_pdie((a),(b))
#endif

/* This is a non-standard assert but it saves quite a lot of
 * space (1kbyte) over the OS version.
 */
#if NDEBUG
#define assert(condition) do;while(0)
#elif 0 /* Expensive string asserts (lots of space in strings). */
static void do_assert(const unsigned char *why)
    __attribute__((noreturn));
static void do_assert(const unsigned char *why) {
	fprintf(stderr, "devio: internal error: %s\n", why);
	exit(error_level);
}
#define assert(condition) do if (!(condition)) do_assert(#condition); while (0)
#else
static void do_assert(int line) __attribute__((noreturn));
static void do_assert(int line) {
	fprintf(stderr, "devio: internal error: %d\n", line);
	exit(error_level);
}
#define assert(condition) do if (!(condition)) do_assert(__LINE__); while (0)
#endif

/* This is a non-ANSI extension. */
unsigned char *my_strdup(const unsigned char *from) {
	size_t cb = strlen(from)+1;
	unsigned char *to = malloc(cb);
	if (to == 0)
		die("out of memory", from);
	memcpy(to, from, cb);
	return to;
}


/***********************************************************************
 * mtd_file
 *
 * Basic device safe IO.
 * Set mtd_seek to set the desired read or write point.
 * Use mtd_getb and mtd_putb to read/write a single byte.
 * Use mtd_readbytes and mtd_writebytes to move multiple bytes.
 *********************************************************************/
/* File structure, used for read and write operations.  stdio() should do
 * everything this does pretty much except that this allows for no-write
 * buffering and it is 'weird' in that it won't overwrite beyond the end
 * of the data. */
typedef struct mtd_file {
	unsigned char* pname;
	int            fwrite;
	int            fverify;  /* do not write, just verify */
	int            fwritten; /* something to do! */
	int            fchanged; /* something was done! */
	int            fd;
	struct stat    stat;
	size_t         cbbuf;
	/* The user pointer is at 'useroffset', the buffer contains data from
	 * 'bufferoffset' to 'deviceoffset' (exclusive - the buffer may be empty), so
	 * the file descriptor is pointing to 'deviceoffset', which may be just beyond
	 * the end of the file.
	 */
	off_t          useroffset;   /* Current user position */
	off_t          bufferoffset; /* Base of current buffer */
	off_t          deviceoffset; /* End of current buffer */
	off_t          endoffset;    /* Length of char or block device. */
	unsigned char* pbuf;
	unsigned char* pwritebuf;
} mtd_file;


/* Initialise an mtd structure. */
static void init_mtd(mtd_file *pfile) {
	pfile->pname = 0;
	pfile->fwrite = 0;
	pfile->fverify = 0;
	pfile->fwritten = 0;
	pfile->fchanged = 0;
	pfile->fd = (-1);
	memset(&pfile->stat, 0, sizeof pfile->stat);
	pfile->cbbuf = 0;
	pfile->useroffset = 0;
	pfile->bufferoffset  = 0;
	pfile->deviceoffset = 0;
	pfile->endoffset = (off_t)-1;
	pfile->pbuf = 0;
	pfile->pwritebuf = 0;
}


/* Return the size, in bytes. */
static size_t size_mtd(mtd_file *pfile) {
	if (S_ISCHR(pfile->stat.st_mode) || S_ISBLK(pfile->stat.st_mode)) {
		if (pfile->endoffset == (off_t)-1) {
			off_t len;
			assert(pfile->stat.st_size == 0);
			assert(pfile->stat.st_blocks == 0);
			assert(pfile->stat.st_blksize > 0);
			/* So seek to the end then come back here. */
			len = lseek(pfile->fd, -pfile->stat.st_blksize, SEEK_END);
			if (len == (off_t)-1)
				pdie("lseek(length)", pfile->pname);
			if (lseek(pfile->fd, pfile->deviceoffset, SEEK_SET) != pfile->deviceoffset)
				pdie("lseek(length reset)", pfile->pname);
			len += pfile->stat.st_blksize;
			pfile->endoffset = len;
		}
		return pfile->endoffset;
	} else if (S_ISDIR(pfile->stat.st_mode) || S_ISFIFO(pfile->stat.st_mode) ||
				S_ISSOCK(pfile->stat.st_mode))
		die("cannot find size of this device", pfile->pname);
	else
		return pfile->stat.st_size;
}


/* Open the named file for read or write, the structure is initialised
 * appropriately.  The name is copied. */
static void new_mtd(mtd_file *pfile, const char *pname, int fwrite, int fverify, int fd) {
	pfile->pname = my_strdup(pname);
	pfile->fwrite = fwrite;
	pfile->fverify = fverify;
	pfile->fwritten = 0;
	pfile->fchanged = 0;
	pfile->fd = fd;

	if (fstat(fd, &pfile->stat) != 0)
		pdie("fstat", pname);
	/* This can be made to work with fifos on read because it is possible
	 * to seek by reading so long as we only seek forward, but it really
	 * isn't worth spending time on this.
	 */
	if (S_ISDIR(pfile->stat.st_mode) || S_ISFIFO(pfile->stat.st_mode) ||
			S_ISSOCK(pfile->stat.st_mode))
		die("invalid device", pname);
	/* Allow writing to a file for testing - i.e. S_ISREG is fine above. */
	pfile->cbbuf = pfile->stat.st_blksize;
	if (pfile->cbbuf == 0)
		pfile->cbbuf = 4096;
	pfile->useroffset = 0;
	pfile->bufferoffset = 0;
	pfile->deviceoffset = 0;
	pfile->pbuf = 0;
	pfile->pwritebuf = 0;
}

static void open_mtd(mtd_file *pfile, const char *pname, int fwrite, int fverify) {
	int fd = open(pname, (fwrite && !fverify) ? O_RDWR : O_RDONLY);
	if (fd < 0)
		pdie("open", pname);
	else if (fd < 3)
		die("no standard streams", "-");
	new_mtd(pfile, pname, fwrite, fverify, fd);
}


/* Do the actual write.  Any pending write buffers are checked and output
 * to the device.  Happens on close and can be called before.  Does not
 * do an fsync.  The fwritten flag indicates that write_mtd needs to be
 * called, the fchanegd flag indicates that something has been written and
 * an fdatasync needs to happen before the close.
 */
static void write_mtd(mtd_file *pfile) {
	if (pfile->fwritten) {
		size_t count = pfile->deviceoffset - pfile->bufferoffset;
		unsigned char *pbuf = pfile->pwritebuf;

		assert(pfile->pbuf != 0);
		assert(pbuf != 0);
		assert(pfile->deviceoffset > pfile->bufferoffset);
		assert(pfile->deviceoffset <= pfile->bufferoffset + pfile->cbbuf);
		/* If it changed write it. */
		if (memcmp(pfile->pbuf, pbuf, count) != 0) {
			/* If verifying the verify just failed... */
			if (pfile->fverify)
				die("verification failed", pfile->pname);

			/* So write the whole of this buffer back.  Do not do a sync here
			 * because that would force a complete write of the flash erase
			 * block - not good.
			 */
			if (lseek(pfile->fd, pfile->bufferoffset, SEEK_SET) != pfile->bufferoffset)
				pdie("lseek(write)", pfile->pname);
			/* write, well, you have to keep doing it until it works, you
			 * also have to RTFM several times to get this write, so if
			 * this looks wrong please fix it.  No, not that, that was
			 * deliberate.
			 */
			do {
				ssize_t cb = write(pfile->fd, pbuf, count);
				assert(cb != 0);
				assert(cb <= count);
				if (cb < 0) switch (errno) {
				case EINTR:  /* shall we try that again then? */
					/* This is the common case - this does happen, it is
					 * necessary to deal with it and it is sufficient to
					 * try again.
					 */
					break;
				case EAGAIN: /* what, oh well, if at once you don't succeed. */
					/* We didn't say O_NONBLOCK above so this should never
					 * happen, however it has.  The code will therefore go into
					 * a tight loop in the manner of a certain Scottish nobleman.
					 */
					break;
				case EPIPE:  /* you don't love me any more. */
					/* This is a little difficult, it means we were squirting
					 * data down a pipe, so somehow someone has managed to work
					 * out both how to create a named pipe and how much fun to
					 * have by passing it to this program on the command line,
					 * then they have worked out how to make the shell ignore
					 * SIGPIPE in a spawned program (possible with some shells)
					 * then they want to see the really dumb message that comes
					 * out as a result.  We just say no.
					 */
					exit(1);
				default:
					pdie("write", pfile->pname);
				} else {
					count -= cb;
					/* It is now necessary to fdatasync this file descriptor
					 * to ensure that this data really does get to its final
					 * destination.  (Note that even this is probably not certain
					 * if the destination is a disk with a RAM buffer - which
					 * means *any* disk these days.)
					 */
					pfile->fchanged = 1;
					/* Something has been written to flash, but not everything
					 * has (necessarily) been written yet, so if something goes
					 * wrong after this point we are in deep, deep, trouble.
					 */
					error_level = 3;
				}
			} while (count > 0);

			/* So now the device matches the write buffer and the device
			 * pointer is back where it was before.
			 */
			memcpy(pfile->pbuf, pfile->pwritebuf, pfile->deviceoffset-pfile->bufferoffset);
		}
		/* Nothing remains to write from this buffer (hence nothing at all
		 * for this device.)
		 */
		pfile->fwritten = 0;
	}
}


/* Close the file, if anything was written out does an fsync.
 */
static void close_mtd(mtd_file *pfile) {
	write_mtd(pfile);
	assert(!pfile->fwritten);
	if (pfile->pbuf != 0) {
		free(pfile->pbuf);
		pfile->pbuf = 0;
	}
	if (pfile->pwritebuf != 0) {
		free(pfile->pwritebuf);
		pfile->pwritebuf = 0;
	}
	if (pfile->fd >= 0) {
		/* For a write file be very very careful.  For read ignore errors:
		 * it is more important to successfully write than to whine about
		 * strange close errors from a file we don't care about.  For a
		 * write file with nothing written we don't care either.
		 */
		if (pfile->fchanged) {
			/* This is the all important bit.  Doing the fdatasync is what
			 * flushes the data to the flash.  If this isn't done there is
			 * no guarantee that close will detect a write error, 'cause the
			 * flash may not have completed the write before the close
			 * returns.
			 */
			if (fdatasync(pfile->fd) != 0) {
				/* Trying an fdatasync on a pipe, etc, is silly, but we do
				 * it anyway.  EROFS means we just tried to write to a
				 * read only file system, safe but still an error.
				 */
				if (errno != EINVAL)
					pdie("sync", pfile->pname);
			}
			if (close(pfile->fd) != 0)
				pdie("close", pfile->pname);
		} else
			(void)close(pfile->fd);
		pfile->fd = (-1);
	}
	if (pfile->pname != 0) {
		free(pfile->pname);
		pfile->pname = 0;
	}
	init_mtd(pfile);
}


/* Obtain an input and, if necessary, an output buffer. */
static void buffer_mtd(mtd_file *pfile) {
	if (pfile->pbuf == 0) {
		size_t blksize = pfile->cbbuf;
		assert(blksize > 0);
		assert(pfile->pwritebuf == 0);

		/* Get blksize bytes (note: things could be speeded up by aligning
		 * the buffer but this really doesn't matter, all the time goes in
		 * read/write of the flash!)
		 */
		pfile->pbuf = malloc(blksize);
		if (pfile->fwrite)
			pfile->pwritebuf = malloc(blksize);
		if (pfile->pbuf == 0 || (pfile->fwrite && pfile->pwritebuf == 0))
			die("out of memory", pfile->pname);
	}
}


/* Read some data including the current user position.  This will also *write* data
 * if something is waiting to be written.
 *
 * NOTE: in the original design I conceived of some scheme whereby all the writes
 * would be buffered up for the end, but I can't see how this would actually help
 * anything because even if data has to be read from the device to determine read
 * locations it tends to happen before the relevant writes.  In the access patterns
 * I know (they are very simple - and that is important in itself) there is never
 * a need to read from a write device.
 */
static void read_mtd(mtd_file *pfile) {
	size_t cbread;
	int ioffset;

	/* 'useroffset' is where we need to read from, 'deviceoffset' is where we are
	 * at (sic) and 'bufferoffset'..'deviceoffset' is what we have already.
	 */
	if (pfile->useroffset >= pfile->bufferoffset &&
		pfile->useroffset < pfile->deviceoffset)
		return;

	if (pfile->useroffset < 0 || pfile->useroffset >= size_mtd(pfile))
		die("read outside file", pfile->pname);

	/* Make sure there is a buffer. */
	buffer_mtd(pfile);

	/* This is the maximum amount which can be read. */
	cbread = pfile->cbbuf;
	if (pfile->useroffset >= pfile->bufferoffset &&
		pfile->useroffset < pfile->bufferoffset + cbread) {
		/* Just fill the rest of the buffer. */
		ioffset = pfile->deviceoffset - pfile->bufferoffset;

		assert(pfile->deviceoffset < pfile->bufferoffset + cbread);
		cbread -= ioffset;
	} else {
		off_t base;

		/* We to move the buffer therefore  any pending write needs to be flushed. */
		write_mtd(pfile);
		assert(!pfile->fwritten);

		/* Seek to the aligned buffer boundary if necessary. */
		base = (pfile->useroffset / cbread) * cbread;
		if (base != pfile->deviceoffset) {
			if (lseek(pfile->fd, base, SEEK_SET) != base)
				pdie("lseek(read)", pfile->pname);
			pfile->deviceoffset = base;
		}
		pfile->bufferoffset = base;
		ioffset = 0;
	}

	/* Reading is like writing, EINTR can stop it succeeding but is a
	 * continuable error.
	 */
	assert(pfile->bufferoffset <= pfile->useroffset);
	assert(pfile->useroffset < pfile->bufferoffset + cbread);
	assert(pfile->deviceoffset <= pfile->useroffset);
	do {
		ssize_t cb = read(pfile->fd, pfile->pbuf+ioffset, cbread);
		if (cb < 0) switch (errno) {
		case EINTR:  /* simple restart */
			/* POSIX allows this to happen when something has been
			 * read.  Reset the file pointer just in case.
			 */
			if (lseek(pfile->fd, pfile->deviceoffset, SEEK_SET) != pfile->deviceoffset)
				pdie("lseek(read reset)", pfile->pname);
			break;
		case EAGAIN: /* O_NONBLOCK on the input? */
			break;
		default:
			pdie("read", pfile->pname);
		} else if (cb == 0) {
			die("unexpected end of file", pfile->pname);
		} else {
			/* Save a copy of the data so that it can be written out again
			 * by a write file.
			 */
			if (pfile->pwritebuf != 0)
				memcpy(pfile->pwritebuf+ioffset, pfile->pbuf+ioffset, cb);
			cbread -= cb;
			ioffset += cb;
			pfile->deviceoffset += cb;
		}
	} while (cbread > 0 && pfile->useroffset >= pfile->deviceoffset);

	assert(pfile->useroffset < pfile->deviceoffset);
}


/* Basic IO - these are the functions to use, not the internal read/write
 * functions above.
 */
/* Set the current read/write pointer on this file. */
#if 0 /*UNUSED*/
static void mtd_seek(mtd_file *pfile, off_t offset) {
	pfile->useroffset = offset;
}
#endif


/* Get a single byte (returned) and advance the read pointer by one. */
static unsigned char mtd_getb(mtd_file *pfile) {
	read_mtd(pfile);
	return (pfile->fwrite ? pfile->pwritebuf : pfile->pbuf)[
		pfile->useroffset++ - pfile->bufferoffset];
}


/* Store a single byte in a write file and advance the pointer by one. */
static void mtd_putb(mtd_file *pfile, unsigned long b) {
	if (!pfile->fwrite)
		die("file is not writeable", pfile->pname);
	read_mtd(pfile);
	if (b != pfile->pwritebuf[pfile->useroffset-pfile->bufferoffset]) {
		pfile->pwritebuf[pfile->useroffset-pfile->bufferoffset] = b;
		pfile->fwritten = 1;
	}
	++(pfile->useroffset);
}


/* Read a given number of bytes, which must exist in the file, and
 * advance the pointer by that amount.
 */
static void mtd_readbytes(mtd_file *pfile, unsigned char *pbuf, size_t cb) {
	if (pfile->useroffset+cb > size_mtd(pfile))
		die("read beyond end of file", pfile->pname);

	while (cb > 0) {
		int cbavail;

		read_mtd(pfile);
		cbavail = pfile->deviceoffset - pfile->useroffset;
		assert(cbavail > 0 && cbavail <= pfile->cbbuf);
		if (cbavail > cb)
			cbavail = cb;

		assert(pfile->useroffset >= pfile->bufferoffset);
		assert(pfile->useroffset < pfile->deviceoffset);
		assert(pfile->deviceoffset <= pfile->bufferoffset + pfile->cbbuf);

		memcpy(pbuf, (pfile->fwrite ? pfile->pwritebuf : pfile->pbuf) +
					(pfile->useroffset-pfile->bufferoffset), cbavail);
		pfile->useroffset += cbavail;
		pbuf += cbavail;
		cb -= cbavail;
	}
}


/* Write a given number of bytes and advance the pointer.  As with readbytes
 * the bytes must already exist in the file - mtd_file will never extend the
 * file only change existing bytes.
 */
static void mtd_writebytes(mtd_file *pfile, const unsigned char *pbuf, size_t cb) {
	if (!pfile->fwrite)
		die("file is not writeable", pfile->pname);
	if (pfile->useroffset+cb > size_mtd(pfile))
		die("write beyond end of file", pfile->pname);
	while (cb > 0) {
		int cbavail;

		/* This may look strange but it is correct - this code always reads
		 * before it writes to avoid unnecessary writes.
		 */
		read_mtd(pfile);
		cbavail = pfile->deviceoffset - pfile->useroffset;
		if (cbavail > cb)
			cbavail = cb;
		memcpy(pfile->pwritebuf + (pfile->useroffset-pfile->bufferoffset), pbuf, cbavail);
		pfile->fwritten = 1;
		pfile->useroffset += cbavail;
		pbuf += cbavail;
		cb -= cbavail;
	}
}


#if 0 /* Commented out because I don't think this is worth while. */
/* Copy bytes from the pointer in one file to the pointer in another
 * file (avoids an intermediate buffer compared to readbytes/writebytes.)
 */
static void mtd_copy(mtd_file *pto, mtd_file *pfrom, size_t cb) {
	int cbfrom, cbto;

	if (!pto->fwrite)
		die("file is not writeable", pto->pname);
	if (pto->useroffset+cb > size_mtd(pto))
		die("write beyond end of file", pto->pname);
	if (pfrom->useroffset+cb > size_mtd(pfrom))
		die("read beyond end of file", pfrom->pname);
	/* Copying from and to the same place has no effect. */
	if (pfrom == pto)
		return;

	cbfrom = cbto = 0;
	while (cb > 0) {
		int cbavail;

		if (cbfrom <= 0) {
			read_mtd(pfrom);
			cbfrom = pfrom->deviceoffset - pfrom->useroffset;
		 compared to readbytes/writebytes}
		if (cbto <= 0) {
			read_mtd(pto);
			cbto = pto->deviceoffset - pto->useroffset;
		}

		/* Take the smallest byte count and copy it. */
		cbavail = cbfrom;
		if (cbavail > cbto)
			cbavail = cbto;
		if (cbavail > cb)
			cbavail = cb;

		memcpy(pto->pwritebuf + (pto->useroffset-pto->bufferoffset),
				pfrom->pbuf + (pfrom->useroffset-pfrom->bufferoffset),
				cbavail);
		pto->fwritten = 1;

		pto->useroffset += cbavail;
		cbto -= cbavail;
		pfrom->useroffset += cbavail;
		cbfrom -= cbavail;

		cb -= cbavail;
	}
}
#endif


/***********************************************************************
 * parse
 *
 * Parse a command line option or a single line.  See the help below
 * for details...
 ***********************************************************************/
#define STACK_BASE 8
#define STACK_SIZE 256
#define NUM_FILES  16
typedef struct parse_buf {
	int           fverify; /* Just verifying, do no write. */
	int           cstack;
	int           fbreak;  /* Break in an expression. */
	mtd_file*     pfrom;
	mtd_file*     pto;

	/* The buffers. */
	unsigned long variables[256];
	unsigned long stack[STACK_SIZE];
	mtd_file      files[NUM_FILES];
} parse_buf;


/* Initialiser. */
static void init_parse(parse_buf *pp, int fverify) {
	int i;
	memset(pp, 0, sizeof *pp);
	pp->fverify = fverify;
	pp->cstack = STACK_BASE;
	pp->fbreak = 0;
	pp->pfrom = 0;
	pp->pto = 0;
	for (i=0; i<NUM_FILES; ++i)
		init_mtd(pp->files+i);
}


/* Terminator. */
static void quit(parse_buf *pp, int exit_code) __attribute__((noreturn));
static void quit(parse_buf *pp, int exit_code) {
	int i;
	/* Close all the files. */
	for (i=0; i<NUM_FILES; ++i)
		if (pp->files[i].pname != 0)
			close_mtd(pp->files+i);

	/* And make sure the output worked too. */
	if (fflush(stdout) == EOF || ferror(stdout) || fclose(stdout) == EOF)
		pdie("output failed", "stdout");

	exit(exit_code);
}


/* Input a single byte. */
static unsigned char inb(parse_buf *pp) {
	int b;
	if (pp->pfrom == 0) {
		b = getchar();
		if (b == EOF)
			pdie("read error", "stdin");
	} else {
		b = mtd_getb(pp->pfrom);
	}
	return b;
}


/* Output a single byte. */
static void outb(parse_buf *pp, unsigned long b) {
	if (pp->pto == 0) {
		if (putchar(b) == EOF)
			pdie("write error", "stdout");
	} else {
		mtd_putb(pp->pto, b);
	}
}


/* Output these bytes. */
static void outputbytes(parse_buf *pp, const char *pbuf, size_t cb) {
	if (pp->pto == 0) {
		if (fwrite(pbuf, cb, 1, stdout) != 1)
			pdie("write error", "stdout");
	} else
		mtd_writebytes(pp->pto, pbuf, cb);
}

/* Copy a stream of bytes. */
static void copybytes(parse_buf *pp, size_t cb) {
	while (cb > 0) {
		size_t cbavail = cb;
		unsigned char buf[1024];
		if (cbavail > sizeof buf)
			cbavail = sizeof buf;
		if (pp->pfrom == 0) {
			if (fread(buf, cbavail, 1, stdin) != 1)
				pdie("read error", "stdin");
		} else
			mtd_readbytes(pp->pfrom, buf, cbavail);

		outputbytes(pp, buf, cbavail);

		cb -= cbavail;
	}
}


/* Fill the output with a count of bytes of a given value. */
static void fillbytes(parse_buf *pp, unsigned long val, size_t cb) {
	unsigned char buf[1024];
	memset(buf, val, sizeof buf);

	while (cb > 0) {
		size_t cbavail = cb;
		if (cbavail > sizeof buf)
			cbavail = sizeof buf;

		outputbytes(pp, buf, cbavail);

		cb -= cbavail;
	}
}


/* Push a single numeric value onto the stack. */
static void push(parse_buf *pp, unsigned long num, const unsigned char *str) {
	if (pp->cstack >= STACK_SIZE)
		die("stack overflow", str);
	pp->stack[pp->cstack++] = num;
}


/* Pop one or move variables. */
static void pop(parse_buf *pp, int num, const unsigned char *str) {
	if (pp->cstack < STACK_BASE+num)
		die("stack underflow", str);
	pp->cstack -= num;
}

/* Return (and pop) the top of stack. */
static unsigned long top(parse_buf *pp, const unsigned char *str) {
	if (pp->cstack <= STACK_BASE)
		die("stack underflow", str);
	return pp->stack[--(pp->cstack)];
}


/* Store the result of an operator. */
static void op(parse_buf *pp, int numpop, unsigned long num,
		const unsigned char *str) {
	pop(pp, numpop, str);
	push(pp, num, str);
}


/* Parse a single expression, which may be empty.  The conditional execution
 * stuff is identical to that for a command except that (:?) are used instead
 * of $($:$?$)
 */
static int parse_expression(parse_buf *pp, const unsigned char *line, int Ac, int AcEnd) {
	int SP = 0, fnoexec = 0, test = 0;
	int stack[16];

	for (;Ac<AcEnd;++Ac) {
		const unsigned char *lp = line+Ac;
		unsigned char ch = *lp;
		switch (ch) {
			/* Control flow.  These operators have to explicitly check
			 * the fnoexec state because they manipulate it.
			 */
		case '(': /* if */
			if (SP >= 16)
				die("() stack overflow", lp);
			stack[SP++] = Ac;
			if (fnoexec) {
				fnoexec += 3;
			} else {
				fnoexec = top(pp, lp) == 0;
			}
			break;

		case '[': /* test start */
			/* If fnoexec >= 3 the whole block is disabled. */
			if (fnoexec <= 2) {
				/* Valid only inside an () block and there should only
				 * be one active at once.
				 */
				if (test != 0 || SP <= 0)
					goto badnest;
				/* Record the start of the test. */
				test = Ac+1;
				/* If the previous block executed record this. */
				if (fnoexec == 0)
					fnoexec = 2;
			}
			break;

		case ':': /* elif */
			/* fnoexec is 1 if nothing has executed in this block yet,
			 * and if the block itself is executing, it is 2 if something
			 * did execute, it is >2 for a non-executed block, including
			 * one with a break.
			 */
			if (fnoexec <= 2) {
				if (test == 0 || SP <= 0)
					goto badnest;

				assert(fnoexec > 0);
				assert(!pp->fbreak);
				/* 1: nothing has executed yet.
				 * 2: an if or elif has executed.
				 */
				if (fnoexec == 1) {
					/* Parse the test.  If this results in a break no
					 * condition is popped from the stack, otherwise
					 * the condition which the expression should push
					 * is popped.
					 */
					(void)parse_expression(pp, line, test, Ac);
					if (pp->fbreak) {
						fnoexec = 3;
						pp->fbreak = 0;
					} else
						fnoexec = top(pp, lp) == 0;
				}

				/* And the test has been consumed. */
				test = 0;
			}
			break;

		case ')': /* end+loop if */
			/* The stack must always be popped. */
			if (SP <= 0)
				goto badnest;
			--SP;
			/* If fnoexec>2 then this is a nested disabled block or, in
			 * the case of 3, a break.  In neither case is the expression
			 * evaluated and the test setting is for an enclosing block.
			 */
			if (fnoexec > 2) {
				fnoexec -= 3;
			} else {
				/* In this case there must be a test. */
				if (test == 0)
					goto badnest;

				/* Execution resumes regardless. */
				fnoexec = 0;
				assert(!pp->fbreak);

				/* So make the loop test now - this may cause a branch back
				 * to the ( and that will push the stack again.  Evaluate
				 * the test.
				 */
				(void)parse_expression(pp, line, test, Ac);
				if (pp->fbreak)
					pp->fbreak = 0;
				else if (top(pp, lp) != 0) {
					Ac = stack[SP]-1; /* Ac is incremented below */
				}

				/* And the test has been consumed. */
				test = 0;
			}
			break;

		badnest:
			die("bad [: or [) nesting", lp);
			break;

		case ';':
		case '\n':
			/* end of line terminates the loop, but Ac is stepped beyond the
			 * terminator.
			 */
			++Ac;
			goto end;

		case ' ':
		case '\f':
		case '\r':
		case '\t':
		case '\v':
		case ',':  /* Treat as a space */
			/* Skip other white space. */
			break;

			/* Everything else is glommed together because the fnoexec case
			 * can be simply handled by skipping character-by-character (because
			 * (:?); do not occur inside numbers!)
			 */
		default:
			if (fnoexec)
				break;

			if (isupper(ch))
				push(pp, pp->variables[ch], lp);
			else if (isdigit(ch)) {
				char *end = (char*)lp;
				unsigned long num;
				errno = 0;
				num = strtoul(lp, &end, 0);
				if (num == ULONG_MAX && (errno == EINVAL || errno == ERANGE))
					pdie("invalid number", lp);
				push(pp, num, lp);
				/* strotul returns a pointer to the first invalid character in
				 * end, so Ac becomes end-line-1, because it is incremented below.
				 */
				Ac = (const unsigned char*)end-line-1;
			} else {
				/* The operators are handled here.  An unrecognised character is an
				 * error at this point.  The left, right are always valid because
				 * the stack has 8 unused slots at the top...
				 */
				unsigned long left = pp->stack[pp->cstack - 2];
				unsigned long right = pp->stack[pp->cstack - 1];

				switch (ch) {
				case '?': /* break */
					/* break inside a condition is actually allowed, so this may
					 * happen with SP==0 while evaluating a condition.  For the
					 * moment ? is also allowed outside a loop, it terminates the
					 * processing of the whole expression.
					 */
					if (top(pp, lp) != 0) {
						/* break: skip to the ) and do not do the test on
						 * that either.
						 */
						fnoexec = 3;
					}
					break;

				#define DIOP(operator) op(pp, 2, left operator right, lp); break
				#define MONOP(operator) op(pp, 1, operator right, lp); break
					/* The C operators */
				case '*': DIOP(*);
				case '+': DIOP(+);
				case '-': DIOP(-);
				case '/': DIOP(/);
				case '%': DIOP(%);
				case '<': DIOP(<);
				case '>': DIOP(>);
				case '|': DIOP(|);
				case '&': DIOP(&);
				case '^': DIOP(^);
				case '~': MONOP(~);
				case '!': MONOP(!);
				case '=': /* equality */
					op(pp, 2, left == right, lp);
					break;
				case '{': /* shift left */
					op(pp, 2, left << right, lp);
					break;
				case '}': /* shift right */
					op(pp, 2, left >> right, lp);
					break;
				case 'r': /* rotate right */
					op(pp, 2, (left >> right) + (left << (32-right)), lp);
					break;
				case 'e': /* sign extend (right is number of valid bits). */
					op(pp, 2, (long)(left << (32-right)) >> (32-right), lp);
					break;
				case 'm': /* mask (right is number of valid bits). */
					op(pp, 2, (left << (32-right)) >> (32-right), lp);
					break;
				case '$': /* Size of input. */
					if (pp->pfrom == 0)
						die("size of input unknown", lp);
					push(pp, size_mtd(pp->pfrom), lp);
					break;
				case 'f': /* position of input ('from' pointer). */
					if (pp->pfrom == 0)
						die("position of input unknown", lp);
					push(pp, pp->pfrom->useroffset, lp);
					break;
				case '#': /* Size of output. */
					if (pp->pto == 0)
						die("size of output unknown", lp);
					push(pp, size_mtd(pp->pto), lp);
					break;
				case 't': /* position of output ('to' pointer). */
					if (pp->pto == 0)
						die("position of output unknown", lp);
					push(pp, pp->pto->useroffset, lp);
					break;
				case 'd': /* device number of the input device */
					if (pp->pfrom == 0)
						die("input device number unknown", lp);
					push(pp, pp->pfrom->stat.st_rdev == 0 ? pp->pfrom->stat.st_dev :
							pp->pfrom->stat.st_rdev, lp);
					break;
				case '@': /* one byte read. */
					push(pp, inb(pp), lp);
					break;
				case 'b': /* big endian 4 byte read. */
					#define P(st) (void)parse_expression(pp, st, 0, (sizeof st)-1)
					P("@8{@+8{@+8{@+;# 4 byte big-endian read");
					break;
				case 'l': /* little endian 4 byte read. */
					P("@@@@8{+8{+8{+;# 4 byte little-endian read");
					break;
				case '.': /* copy (dup) */
					push(pp, right, lp);
					break;
				case 'p': /* pop */
					pop(pp, 1, lp);
					break;
				case 's': /* swap (top two elements of the stack) */
					pop(pp, 2, lp);
					push(pp, right, lp);
					push(pp, left, lp);
					break;
				default:
					die("invalid operator", lp);
				}
			}
		}
	}

	/* Here on terminator or Ac==AcEnd. */
end:
	/* If SP>0 then there was some bad nesting going on - i.e. the brackets have
	 * not been closed.  fnoexec must be zero if SP is 0.
	 */
	if (SP > 0)
		die("unclosed ( )", line);
	assert(fnoexec == 0 || fnoexec == 3);
	if (fnoexec == 3)
		pp->fbreak = 1;
	return Ac;
}


/* Parse an expression and return numbers off the top of stack. */
static int need(parse_buf *pp, unsigned long arg[2],
		const unsigned char *line, int Ac, int AcEnd, int num) {
	int Acnew = parse_expression(pp, line, Ac, AcEnd);

	assert(num <= 2);
	if (pp->cstack < STACK_BASE+num)
		die("too few arguments", line+Ac);

	while (num > 0)
		arg[--num] = pp->stack[--(pp->cstack)];

	/* cancel a break at the top level. */
	pp->fbreak = 0;
	return Acnew;
}


/* Parse a string.  The string ends up in the buffer and is limited in
 * size to STR_MAX.  The API returns a null string for empty quoted
 * strings and for the unquoted case where there is only whitespace
 * in the rest of the command.  The result is the index of the first
 * character after the end of the command (*not* the end of the string.)
 */
static int string(unsigned char *buffer, const unsigned char *line, int Ac) {
	int start, end;

	while (isspace(line[Ac]) && line[Ac] != '\n') ++Ac;

	if (line[Ac] == '"' || line[Ac] == '\'') {
		const unsigned char quote = line[Ac];
		start = Ac;
		end = Ac+1;
		while (line[end] != 0 && line[end] != '\n' && line[end] != quote) ++end;
		if (line[end] != quote)
			die("unterminated quoted string", line+start);
		Ac = end+1;
		while (isspace(line[Ac]) && line[Ac] != '\n') ++Ac;
		if (line[Ac] != 0 && line[Ac] != ';' && line[Ac] != '\n')
			die("stuff on line after quoted string", line+start);
		++start;
	} else {
		start = Ac;
		while (line[Ac] != 0 && line[Ac] != ';' && line[Ac] != '\n') ++Ac;
		end = Ac;
	}

	end -= start;
	if (end >= STR_MAX)
		die("string too long", line+start);

	/* Copy out the string into the buffer and null terminate it. */
	memcpy(buffer, line+start, end);
	buffer[end] = 0;

	/* Skip over EOL, if present, and store the string pointer back. */
	if (line[Ac] != 0) ++Ac;
	return Ac;
}


/* Find the end of line, Ac always points to the start. */
static int eol(const unsigned char *line, int Ac) {
	unsigned char quote = 0;
	while (line[Ac] != '\n' && (line[Ac] != ';' || quote)) {
		if (line[Ac] == 0)
			return Ac;
		if (line[Ac] == '"' || line[Ac] == '\"') {
			if (quote == 0)
				quote = line[Ac];
			else if (quote == line[Ac])
				quote = 0;
		}
		++Ac;
	}
	return Ac+1;
}


/* Find a file given its name. */
static mtd_file *find_file(parse_buf *pp, const unsigned char *name) {
	int i;
	for (i=0; i<NUM_FILES; ++i) {
		if (pp->files[i].pname != 0 &&
			strcmp(name, pp->files[i].pname) == 0)
			return pp->files+i;
	}
	return 0;
}


/* Open a file for read or write. */
static mtd_file *open_file(parse_buf *pp, const unsigned char *name, int fwrite) {
	int i;
	for (i=0; i<NUM_FILES; ++i)
		if (pp->files[i].pname == 0)
			break;
	if (i >= NUM_FILES)
		die("no more files", name);
	open_mtd(pp->files+i, name, fwrite, pp->fverify);
	return pp->files+i;
}


/* Basic parse function.  Does all the work.  Simple line-by-line command
 * parser.  The input is a vector of strings (an argv), 'input' says where
 * it came from.
 */
static void parse(parse_buf *pp, int lines, const char **prog) {
	/* The program pointer is a line index Al and a character within the
	 * line Ac.  The exec stack just has those references (i.e. (Al,Ac)
	 * is a PC).
	 */
	int Al = 0, SP = 0, fnoexec = 0;
	struct stack {
		int Al, Ac;
	} stack[16];

	/* fnoexec has these values:
	 *    0: normal execution
	 *    1: within an if $($:$) and none of the tests have passed (so
	 *       nothing has been executed in this block.)
	 *    2: within an if and a test has passed (a previous block has
	 *       been executed.)
	 *    3: within an if and a break ($?) has succeeded, execute nothing
	 *       until *and including* the $) (i.e. do not evaluate the value
	 *       on that either.)
	 * This applies to nested if blocks too when the block is executable.
	 * If a block is nested within a non-executing environment the $(
	 * adds 3 to fnoexec.  The $) always subtracts 3 unless fnoexec is
	 * 0, 1, 2 or 3 thus the prior state is reliably restored.
	 */

	while (Al < lines) {
		int Ac = 0;
		const unsigned char *line = prog[Al];
		const int AcEnd = strlen(line);

		while (line[Ac]) {
			const unsigned char *lp = line+Ac;
			unsigned char ch = *lp;

			/* A command is two characters, except that ';' is end-of-line,
			 * skip these things until we see a command, then use the next
			 * two characters.  line[Ac] != 0 so the read of Ac+1 is safe.
			 */
			if (isspace(ch) || ch == ';') {
				++Ac;
			} else if ((ch != '$' && fnoexec) || ch == '#') {
				/* disabled execution and not a control flow command, or
				 * a comment.
				 */
				Ac = eol(line, Ac);
			} else switch ((ch << 8) + line[Ac+1]) {
				unsigned long arg[2];
				unsigned char buffer[STR_MAX];

				/* Control flow.  These commands have to explicitly check
				 * the fnoexec state because they manipulate it.
				 */
			#define CASE(l,r) case (((l)<<8)+(r))
			CASE('$','('): /* if */
				if (SP >= 16)
					die("exec stack overflow", lp);
				stack[SP].Al = Al;
				stack[SP++].Ac = Ac;
				if (fnoexec) {
					fnoexec += 3;
					goto noexec;
				}
				Ac = need(pp, arg, line, Ac+2, AcEnd, 1);
				fnoexec = arg[0] == 0;
				break;

			CASE('$',':'): /* elif */
				/* fnoexec is 1 if nothing has executed in this block yet,
				 * and if the block itself is executing.
				 */
				if (SP <= 0)
					goto underflow;
				if (fnoexec != 1) {
					/* If the previous block executed record this. */
					if (fnoexec == 0)
						fnoexec = 2;
					goto noexec;
				}
				Ac = need(pp, arg, line, Ac+2, AcEnd, 1);
				fnoexec = arg[0] == 0;
				break;

			CASE('$',')'): /* end+loop if */
				/* The stack must always be popped. */
				if (SP <= 0)
					goto underflow;
				--SP;
				/* If fnoexec>2 then this is a nested disabled block or, in
				 * the case of 3, a break.  In neither case is the expression
				 * evaluated.
				 */
				if (fnoexec > 2) {
					fnoexec -= 3;
					goto noexec;
				}
				fnoexec = 0;
				/* So make the loop test now - this may cause a branch back
				 * to the $( and that will push the stack again.
				 */
				Ac = need(pp, arg, line, Ac+2, AcEnd, 1);
				if (arg[0] != 0) {
					Al = stack[SP].Al;
					Ac = stack[SP].Ac;
					/* Do not ever forget this, because we may not exit the
					 * immediately enclosing loop and line is set up outside
					 * it!
					 */
					line = prog[Al];
				}
				break;

			CASE('$','?'): /* break */
				if (SP <= 0)
					goto underflow;
				if (fnoexec)
					goto noexec;
				Ac = need(pp, arg, line, Ac+2, AcEnd, 1);
				if (arg[0] != 0) {
					/* break: skip to the $) and do not do the test on
					 * that either.
					 */
					fnoexec = 3;
				}
				break;

			underflow:
				die("exec stack underflow", lp);
			noexec:
				/* Control flow no-exec case. */
				Ac = eol(line, Ac);
				break;

				/* Program termination */
			CASE('!','?'): /* exit if non-zero */
				Ac = need(pp, arg, line, Ac+2, AcEnd, 1);
				if (arg[0] != 0)
					quit(pp, arg[0]);
				break;

			CASE('!','!'): /* exit unconditionally */
				Ac = need(pp, arg, line, Ac+2, AcEnd, 1);
				quit(pp, arg[0]);
				break;

				/* Input/output */
			CASE('>','>'): /* write to (no argument reverts to stdout) */
				Ac = string(buffer, line, Ac+2);
				if (buffer[0] != 0) {
					mtd_file *pfile = find_file(pp, buffer);
					if (pfile == 0)
						pfile = open_file(pp, buffer, 1);
					else if (!pfile->fwrite)
						die("attempt to open a read file for write", buffer);
					pp->pto = pfile;
				} else
					pp->pto = 0;
				break;

			CASE('<','<'): /* read from */
				Ac = string(buffer, line, Ac+2);
				if (buffer[0] != 0) {
					mtd_file *pfile = find_file(pp, buffer);
					if (pfile == 0)
						pfile = open_file(pp, buffer, 0);
					pp->pfrom = pfile;
				} else
					pp->pfrom = 0;
				break;

			CASE('<','>'): /* close */
			CASE('>','<'): /* synonym of close */
				Ac = string(buffer, line, Ac+2);
				if (buffer[0] != 0) {
					mtd_file *pfile = find_file(pp, buffer);
					if (pfile == 0)
						die("no such file to close", buffer);

					if (pfile == pp->pfrom)
						pp->pfrom = 0;
					if (pfile == pp->pto)
						pp->pto = 0;
					close_mtd(pfile);
				} else
					die("<> (close) requires an argument", lp);
				break;

			CASE('>','='): /* set to pointer */
				Ac = need(pp, arg, line, Ac+2, AcEnd, 1);
				if (pp->pto == 0)
					die("no output file", lp);
				pp->pto->useroffset = arg[0];
				break;

			CASE('<','='): /* set from pointer */
				Ac = need(pp, arg, line, Ac+2, AcEnd, 1);
				if (pp->pfrom == 0)
					die("no input file", lp);
				pp->pfrom->useroffset = arg[0];
				break;

				/* writing to output */
			CASE('w','b'): /* bigendian number bytes */
				Ac = need(pp, arg, line, Ac+2, AcEnd, 2);
				switch (arg[1]) {
				case 4: outb(pp, arg[0] >> 24);
				case 3: outb(pp, arg[0] >> 16);
				case 2: outb(pp, arg[0] >>  8);
				case 1: outb(pp, arg[0]);
						break;
				default:die("byte count out of range", lp);
				}
				break;

			CASE('w','l'): /* little endian number bytes */
				Ac = need(pp, arg, line, Ac+2, AcEnd, 2);
				switch (arg[1]) {
				case 4: outb(pp, arg[0]); arg[0] >>= 8;
				case 3: outb(pp, arg[0]); arg[0] >>= 8;
				case 2: outb(pp, arg[0]); arg[0] >>= 8;
				case 1: outb(pp, arg[0]);
						break;
				default:die("byte count out of range", lp);
				}
				break;

			CASE('w','s'): /* write string */
				Ac = string(buffer, line, Ac+2);
				outputbytes(pp, buffer, strlen(buffer));
				break;

			CASE('f','b'): /* fill bytes */
				Ac = need(pp, arg, line, Ac+2, AcEnd, 2);

				/* The likely error is forgetting an argument, that may
				 * put the byte count into the fill value.
				 */
				if (arg[1] > 255)
					die("fill value out of range", lp);

				/* Now call fillbytes, arguments same order as memset, but
				 * the reverse from the command (fb number value).
				 */
				fillbytes(pp, arg[1], arg[0]);
				break;

			CASE('c','p'): /* copy bytes */
				Ac = need(pp, arg, line, Ac+2, AcEnd, 1);
				copybytes(pp, arg[0]);
				break;

				/* writing to stdout */
			CASE('p','r'): /* printf("%lu\n") */
				Ac = need(pp, arg, line, Ac+2, AcEnd, 1);
				printf("%lu\n", arg[0]);
			stdout_check:
				if (ferror(stdout))
					pdie("write error", "stdout");
				break;

			CASE('p','f'): /* printf(string) */
				Ac = string(buffer, line, Ac+2);
				/* This flushes the whole stack, so "printf;" can be useful
				 * under some circumstances!
				 */
					{
					unsigned long *stack = pp->stack + pp->cstack - 1;
					pp->cstack = STACK_BASE;
					printf(buffer, stack[0], stack[-1], stack[-2], stack[-3],
									stack[-4], stack[-5], stack[-6], stack[-7]);
					}
				goto stdout_check;

			CASE('p','n'): /* printf("\n") */
				Ac = need(pp, arg, line, Ac+2, AcEnd, 0);
				printf("\n");
				goto stdout_check;


			CASE('.','='): /* eval */
				Ac = need(pp, arg, line, Ac+2, AcEnd, 0);
				break;

			default:
				/* Assignment is handled here. */
				if (isupper(ch) && line[Ac+1] == '=') {
					/* Assignment. */
					Ac = need(pp, arg, line, Ac+2, AcEnd, 1);
					pp->variables[ch] = arg[0];
				} else
					die("unknown command", lp);
				break;
			}
		}

		/* end of line (line[Ac] is '\0'), move to the next line. */
		++Al;
	}

	/* If SP>0 then there was some bad nesting going on - i.e. the brackets have
	 * not been closed.  fnoexec must be zero if SP is 0.
	 */
	if (SP > 0)
		die("unclosed $( $)", "eof");
	assert(fnoexec == 0);
}

/* The command only understands two options, -v for verify and -h for
 * help.
 */
int main(int argc, const char **argv) {
	int i = 0;
	parse_buf p;

	/* the option must be the first argument. */
	if (argc < 2 || strcmp(argv[1], "-h") == 0) {
		fprintf(stderr, "%s: usage: %s ([-v] {comands} |-h [command])\n", argv[0], argv[0]);
#if HELP
		if (argc < 3) {
			fprintf(stderr, " options:\n"
							"  -v: do not write, just verify a previous write\n"
							"  -h: output this help\n"
							"  -h commands: output command help\n"
							"  -h <command>: output help for command <command>\n");
		} else {
			for (i=2; i<argc; ++i) {
				const unsigned char *p = argv[i];
				switch ((argv[i][0] << 8) + argv[i][1]) {
				CASE('a','d'):
					p = "Enter the keyword in [] contained after the command list\n"
						"for more information about those commands";
					break;
				CASE('c','o'):
					if (argv[i][2] != 'n')
						p = " commands are terminated by ';', newline or the end of input:\n"
						"  <command> {arguments} ;\n\n"
						" command: a two character command:       [additional info]\n"
						"  conditional execution: $( $: $? $)     [conditional]\n"
						"  program termination:   !? !!           [exit]\n"
						"  input/output control:  >> << <> >= <=  [io]\n"
						"  writing to the output: wb wl ws fb cp  [write]\n"
						"  writing to stdout:     pr pf pn        [messages]\n"
						"  assignment:            <C>= .=         [assign]\n"
						"  comment:               #\n\n"
						"  -h <command>: output the syntax of command <command>\n\n"
						" arguments: a string or a postfix numeric expression\n"
						"  -h string:   output the syntax of a string argument\n"
						"  -h number:   output the syntax of a numeric argument\n"
						"  -h operator: output a summary of the operators\n\n"
						" A command which starts with '#' is ignored (a comment).";
					else
						p = "conditional evalation\n"
						"  Conditional evalation has the general form:\n\n"
						"    $( cond; $? cond; $: cond; $) cond;  (command form)\n"
						"    cond(,  cond?,  [cond:,  [cond),     (operator from)\n\n"
						"  Conditional commands bracket other commands, conditional\n"
						"  operators bracket other numbers and operators in the expression\n"
						"  The conditions (cond) are intrepreted as boolean values, with 0\n"
						"  false and any other value true.  Notice that the numbers come off\n"
						"  the number stack so it is not necessary for them to be given with\n"
						"  the specific command or before the specifc operator but it can\n"
						"  be very confusing if this is not done.\n\n"
						"  The commands/operators behave exactly as the following ANSI C\n"
						"  syntax:\n\n"
						"    $( n       do if (n) {\n"
						"    $? n       if (n) break;\n"
						"    $: n       } else if (n) {\n"
						"    $) n       } while (n);\n\n"
						"  Thus a simple if/then/else sequence might be:\n\n"
						"    $( condition; $: 1; $) 0\n"
						"    condition( [1: [0)\n\n"
						"  And a simple do while loop:\n\n"
						"    $( 1; $) condition\n"
						"    1( [condition)\n\n"
						"  Notice that the operator syntax requires [cond: and [cond)";
					break;
				CASE('$','('): /* if */
					p = "conditional: $( condition;  do if (condition) {\n";
					break;
				CASE('$',':'): /* elif */
					p = "conditional: $( condition;  } else if (condition) {\n";
					break;
				CASE('$',')'): /* end+loop if */
					p = "conditional: $: condition;  } while (condition);\n";
					break;
				CASE('$','?'): /* break */
					p = "conditional: $: condition;  if (condition) break;\n";
					break;
				CASE('e','x'):
					p = "program termination commands:\n"
						"  !? and !! cause immediate termination of the program.\n"
						"  The currently opened files are closed (and flushed) on\n"
						"  termination and the program exits with the given code.\n"
						"  !? is condition - it only causes an exit if the code is\n"
						"  non zero.";
					break;
				CASE('!','?'): /* exit if non-zero */
					p = "exit: !? code;  if (code != 0) exit(code);\n";
					break;
				CASE('!','!'): /* exit unconditionally */
					p = "exit: !! code;  exit(code);\n";
					break;
				CASE('i','o'):
					p = "input/output control:\n"
						"  >> << allow files to be opened for write or read (respectively)\n"
						"  A file may be opened for both write and read, but in that case\n"
						"  the first open must be the write one.  Such a file has only one\n"
						"  position pointer.  Supplying an empty file name to the commands\n"
						"  causes the standard IO stream (stdout or stdin) to be used, but\n"
						"  the file remains open.  A file may be reselected by repeating\n"
						"  the open command.  The position pointer will not have changed.\n\n"
						"  <> closes a file.  If it is the current input or output then the\n"
						"  input or output, as appropriate, is redirected to the standard\n"
						"  streams.\n\n"
						"  <= >= set the input (from) or output (to) pointer.  The pointer is\n"
						"  changed on the current input or output device and is a property of\n"
						"  that device, not a global setting.";
					break;
				CASE('>','>'): /* write to (no argument reverts to stdout) */
					p = "io: >> file;  select file as the current output device\n"
						"    >> ;      select stdout as the current output device\n";
					break;
				CASE('<','<'): /* read from */
					p = "io: << file;  select file as the current input device\n"
						"    << ;      select stdin as the current input device\n";
					break;
				CASE('<','>'): /* close */
					p = "io: <> file;  close file\n";
					break;
				CASE('>','<'): /* synonym of close */
					p = "io: <> file;  close file\n";
					break;
				CASE('>','='): /* set to pointer */
					p = "io: >= offset;  set the 'to' pointer: output device file pointer\n";
					break;
				CASE('<','='): /* set from pointer */
					p = "io: <= offset;  set the 'from' pointer: input device file pointer\n";
					break;
				CASE('w','r'):
					p = "writing to the output:\n"
						"  wb, wl, ws, fb and cp write bytes to the current output device at\n"
						"  the current output position (which may be set using >=.)\n\n"
						"  See the individual command descriptions for more information.";
					break;
				CASE('w','b'): /* bigendian number bytes */
					p = "write: wb number bytes; write number in bytes big endian bytes\n";
					break;
				CASE('w','l'): /* little endian number bytes */
					p = "write: wl number bytes; write number in bytes little endian bytes\n";
					break;
				CASE('w','s'): /* write string */
					p = "write: wl string;       write string\n";
					break;
				CASE('f','b'): /* fill bytes */
					p = "write: fb number byte;  write number bytes of value 'byte'\n";
					break;
				CASE('c','p'): /* copy bytes */
					p = "write: cp number;       copy number bytes from input to output\n";
					break;
				CASE('m','e'):
					p = "writing to stdout:\n"
						"  pr pf and pn allow output to stdout ignoring the current output\n"
						"  device.  pf uses a C printf(3) format string and no checking is\n"
						"  made on the validity or number of parameters.  The program will\n"
						"  crash if a pointer format (like %s) is used.  This is by design.\n"
						"  Use of \\ escapes within the string will probably not produce the\n"
						"  expected result.  The only way to output a newline is via the\n"
						"  separate pn command.";
					break;
				CASE('p','r'): /* printf("%lu\n") */
					p = "message: pr number;   printf(\"%lu\\n\", number);\n";
					break;
				CASE('p','f'): /* printf(string) */
					p = "message: pf string;   printf(string, 1, 2, 3, 4, 5, 6, 7, 8)\n"
						"                      uses string as a format string for the\n"
						"                      top (up to) 8 arguments on the stack\n"
						"                      Empties the stack!\n";
					break;
				CASE('p','n'): /* printf("\n") */
					p = "message: pn;          prints a newline (printf(\"\\n\");)\n";
					break;
				CASE('.','='):
					p = ".= [number]\n"
						"  The number is evaluated and pushed to the stack";
				CASE('a','s'):
					p = "<C>= [number] (<C> is an upper case character in the range A-Z)\n"
						"  The number is assigned to the variable <C>.";
					break;
				CASE('s','t'):
					p = "string format\n"
						"  A string is either quoted or unquoted.  An unquoted string is\n"
						"  the rest of the line, terminated by ';' or newline (or the end\n"
						"  of the command).  A quoted string is enclosed in either single\n"
						"  or double quotes (which are removed) and must be the only thing\n"
						"  on the line apart from white space.";
					break;
				CASE('n','u'):
					p = "number format\n"
						"  A number is a post-fix expression consisting of numeric values,\n"
						"  variable values and operators.\n"
						"  A numeric value is anything starting with a digit.  0x prefixes a\n"
						"  hexadecimal value, 0 prefixes an octal value otherwise the value\n"
						"  is interpreted as decimal.\n"
						"  Variables are single upper case characters in the range A-Z,\n"
						"  thus 26 variables are available.\n"
						"  Numeric values and variables are pushed onto a stack which can\n"
						"  store up to 248 numbers.\n"
						"  Operators are single characters not identified as numeric values\n"
						"  or variables.  They operate on the stack combining elements.\n"
						"  Use -h operators for more information.";
					break;
				CASE('o','p'):
					p = "operators\n"
						"  The following operators are defined.  Operators take one or\n"
						"  two elements from the stack and push back up to two elements\n"
						"  The conditional operators (:?) are special, see the description\n"
						"  under -h conditionals for more information.  (Conditional\n"
						"  operators and the conditional commands behave identically.)\n\n"
						"  In the following descriptions 'left' is the last-but-one\n"
						"  number on the stack and 'right' is the last number pushed.\n"
						"  'new' is a new number pushed on to the top of the stack.\n\n"
						" arithmetic operators:\n"
						"     *: new := left * right        (multiplication)\n"
						"     +: new := left + right\n"
						"     -: new := left - right\n"
						"     /: new := left / right        (division)\n"
						"     %: new := left % right        (i.e. C style modulus)\n"
						"     <: new := left < right\n"
						"     >: new := left > right\n"
						"     =: new := left == right       (i.e. equality)\n"
						"     |: new := left | right        (bitwise or)\n"
						"     &: new := left | right        (bitwise and)\n"
						"     ^: new := left | right        (bitwise xor)\n"
						"     ~: new := ~right              (ones complement)\n"
						"     !: new := !right              (logical complement - right == 0)\n"
						"     {: new := left << right       (bitwise shift left by right bits)\n"
						"     }: new := left << right       (bitwise shift right by right bits)\n"
						"     r: new := left ROR right      (bitwise rotate right by right bits)\n"
						"     e: new := left SXT right      (right least significant bits of\n"
						"                                    left are sign extended to 32 bits)\n"
						"     m: new := left MASK right     (right least significant bits of left\n"
						"                                    are masked, upper bits become 0)\n"
						" operators to read bytes:\n"
						"     @: new := input-byte          (one byte is read from current input)\n"
						"     b: new := input-big-endian    (4 big endian bytes are read)\n"
						"     l: new := input-little-endian (4 little endian bytes)\n"
						" enquiry operators:\n"
						"     $: the size of the current input device\n"
						"     f: the current 'from' offset\n"
						"     #: the size of the current output device\n"
						"     t: the current 'to' offset\n"
						"     d: the full device number of the current input device\n"
						"        this returns the number of the underlying device for a file\n"
						" operators to manipulate the stack:\n"
						"     .: new := right,right         (i.e. right is duplicated)\n"
						"     p: pop - right is removed from the stack\n"
						"     s: swap - right and left are swapped on the stack\n"
						" conditional operators:\n"
						"     ( exec := right         (execution is stopped if right is 0)\n"
						"     : exec := else if right (execution is resumed or stopped)\n"
						"     ? if right break        (break out of if/loop if right)\n"
						"     ) loop if right         (end of current if/loop)";
					break;
				default:
					fprintf(stderr, "command '%s' not recognised\n", p);
					p = 0;
				}

				if (p != 0)
					fprintf(stderr, "%s\n", p);
			}
		}
#endif
		exit(1);
	} else if (strcmp(argv[1], "-v") == 0)
		i = 1;
		
	init_parse(&p, i);
	++i;
	parse(&p, argc-i, argv+i);
	quit(&p, 0);
}
