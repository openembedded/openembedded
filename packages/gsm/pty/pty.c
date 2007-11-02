/*
 * Copyright (C) 2007 OpenedHand, Ltd.
 * Contact: <andrew@o-hand.com>
 *
 * This file is licensed under the terms of GNU GPL v2.
 *
 * $ pty [<hostname|ip> <port>]
 * Opens a new pseudo terminal and forwards data between standard input
 * and the pty and between the pty and standard output.  If a hostname and
 * port number are given, reads and writes to the socket instead of
 * standard input or output.  Path to the slave pty is printed on standard
 * error.
 */
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>
#include <errno.h>
#include <stdio.h>
#include <string.h>
#include <sys/ioctl.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <poll.h>

#define CHECK(val, name)	\
	if (val == -1) {	\
		fprintf(stderr, #name ": %s (%i)\n", strerror(errno), errno);\
		return -errno;	\
	}

#define min(a, b)	((a) < (b) ? (a) : (b))
#define max(a, b)	((a) > (b) ? (a) : (b))

static int forward2(int in0, int out0, int in1, int out1,
		int (*closed)(int fd)) {
	int inpos = 0, inlen = 0, outpos = 0, outlen = 0, ret, n;
	fd_set rfds, wfds;
	char in[0x100], out[0x100];

	n = max(max(in0, in1), max(out0, out1)) + 1;
	while (1) {
		FD_ZERO(&rfds);
		FD_ZERO(&wfds);
		if (inlen < sizeof(in))
			FD_SET(in0, &rfds);
		if (outlen < sizeof(out))
			FD_SET(in1, &rfds);
		if (inlen)
			FD_SET(out0, &wfds);
		if (outlen)
			FD_SET(out1, &wfds);
		CHECK(select(n, &rfds, &wfds, 0, 0), select);

		if (FD_ISSET(in0, &rfds)) {
			ret = (inpos + inlen) & (sizeof(in) - 1);
			ret = read(in0, in + ret,
					sizeof(in) - max(ret, inlen));
			CHECK(ret, read(0));
			if (!ret)
				return 0;
			inlen += ret;
		}
		if (FD_ISSET(in1, &rfds)) {
			ret = (outpos + outlen) & (sizeof(out) - 1);
			ret = read(in1, out + ret,
					sizeof(out) - max(ret, outlen));
			if (ret > 0)
				outlen += ret;
			if (ret < 0 && errno == EIO && closed) {
				in1 = out0 = closed(in1);
				if (in1 < 0)
					return in1;
				n = max(max(in0, in1), max(out0, out1)) + 1;
				continue;
			}
		}
		if (FD_ISSET(out0, &wfds)) {
			ret = write(out0, in + inpos,
					min(sizeof(in) - inpos, inlen));
			CHECK(ret, write(pty));
			inlen -= ret;
			inpos += ret;
			inpos &= sizeof(in) - 1;
		}
		if (FD_ISSET(out1, &wfds)) {
			ret = write(out1, out + outpos,
					min(sizeof(out) - outpos, outlen));
			CHECK(ret, write(1));
			outlen -= ret;
			outpos += ret;
			outpos &= sizeof(out) - 1;
		}
	}

	return pause();
}

static int reopen(int fd) {
	const char *name = ttyname(fd);

	CHECK(close(fd), close(pty));
	fd = open(name, O_RDWR | O_NOCTTY);
	CHECK(fd, open);
	CHECK(grantpt(fd), grantpt);
	CHECK(unlockpt(fd), unlockpt);

	fprintf(stderr, "%s\n", ptsname(fd));
	return fd;
}

int main(int argc, char *argv[], char **envp) {
	int sock, fd;
	struct sockaddr_in sa;
	struct hostent *hi;

	fd = posix_openpt(O_RDWR | O_NOCTTY);
	CHECK(fd, open);
	CHECK(grantpt(fd), grantpt);
	CHECK(unlockpt(fd), unlockpt);

	fprintf(stderr, "%s\n", ptsname(fd));
#if 0
	/* Connect stdin & stdout with a pty */
	CHECK(close(0), close(0));
	CHECK(close(1), close(1));
	CHECK(dup(fd), dup(0));
	CHECK(dup(fd), dup(1));
	return pause();
#endif
	if (argc != 3)
		return forward2(0, fd, fd, 1, reopen);

#if 0
	/* Connect a sub-process with a pty */
	for (len = 0, i = 1; i < argc; i ++)
		len += strlen(argv[i]) + 4;
	param = malloc(len);
	strcpy(param, argv[1]);
	for (i = 2; i < argc; i ++)
		sprintf(param + strlen(param), " \"%s\"", argv[i]);
	i = fileno(popen(param, O_RDWR));
	CHECK(i, popen);
	free(param);
	return forward2(i, fd, fd, i, reopen);
#endif

	/* Connect a TCP socket with a pty */
	hi = gethostbyname(argv[1]);
	if (!hi) {
		errno = h_errno;
		CHECK(-1, gethostbyname);
	}
	sa.sin_family = hi->h_addrtype;
	memcpy(&sa.sin_addr.s_addr, hi->h_addr_list[0], hi->h_length);
	sa.sin_port = htons(strtol(argv[2], 0, 0));
	sock = socket(AF_INET, SOCK_STREAM, 0);

	CHECK(sock, socket);
	CHECK(connect(sock, (struct sockaddr *) &sa, sizeof(sa)), connect);
	return forward2(sock, fd, fd, sock, reopen);
}
