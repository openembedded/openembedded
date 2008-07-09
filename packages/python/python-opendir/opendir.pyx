##############################################################
#
#   opendir.pyx - A class exposing the functionality of
#   ===========   the opendir() family of C libary functions.
#
#   By Gregory Ewing
#   greg.ewing@canterbury.ac.nz
#
#   This software and derivative works created from it
#   may be used and redistributed without restriction.
#
##############################################################

cdef extern from "sys/errno.h":
	int errno

cdef extern from "stdio.h":
	char *strerror(int)

cdef extern from "dirent.h":
	ctypedef struct DIR
	struct dirent:
		int d_namlen
		char d_name[1]
	DIR *c_opendir "opendir" (char *)
	int readdir_r(DIR *, dirent *, dirent **)
	long telldir(DIR *)
	void seekdir(DIR *, long)
	void rewinddir(DIR *)
	int closedir(DIR *)
	int dirfd(DIR *)

#------------------------------------------------------------------

cdef class opendir:
	"""opendir(pathname) --> an open directory object
	
	Opens a directory and provides incremental access to
	the filenames it contains. May be used as a file-like
	object or as an iterator.
	
	When used as a file-like object, each call to read()
	returns one filename, or an empty string when the end
	of the directory is reached. The close() method should
	be called when finished with the directory.
	
	The close() method should also be called when used as
	an iterator and iteration is stopped prematurely. If
	iteration proceeds to completion, the directory is
	closed automatically."""

	cdef DIR *dir
	
	def __cinit__(self, char *path):
		self.dir = c_opendir(path)
		if not self.dir:
			raise IOError(errno, "%s: '%s'" % (strerror(errno), path))
	
	def __dealloc__(self):
		if self.dir:
			closedir(self.dir)

	def read(self):
		"""read() --> filename or empty string
		
		Returns the next filename from the directory, or an empty
		string if the end of the directory has been reached."""
		
		cdef dirent entry, *result
		check_open(self)
		if readdir_r(self.dir, &entry, &result) < 0:
			raise IOError(errno)
		if result:
			return entry.d_name
		else:
			return ""
	
	def tell(self):
		"""tell() --> position
		
		Returns a value representing the current position in the
		directory, suitable for passing to tell(). Only valid for
		this directory object as long as it remains open."""
		
		check_open(self)
		return telldir(self.dir)

	def seek(self, long pos):
		"""seek(position)
		
		Returns the directory to the specified position, which
		should be a value previously returned by tell()."""
		
		check_open(self)
		seekdir(self.dir, pos)
	
	def rewind(self):
		"""rewind()
		
		Resets the position to the beginning of the directory."""
		
		check_open(self)
		rewinddir(self.dir)
	
	def close(self):
		"""close()
		
		Closes the directory and frees the underlying file descriptor."""
		
		if self.dir:
			if closedir(self.dir) < 0:
				raise IOError(errno)
			self.dir = NULL

#  MaxOSX doesn't seem to have dirfd, despite what the
#  man page says. :-(
#
#	def fileno(self):
#		"""fileno() --> file descriptor
#		
#		Returns the file descriptor associated with the open directory."""
#
#		check_open(self)
#		return dirfd(self.dir)

	def __iter__(self):
		return self
	
	def __next__(self):
		"""next() --> filename
		
		Returns the next filename from the directory. If the end of the
		directory has been reached, closes the directory and raises
		StopIteration."""

		if self.dir:
			result = self.read()
			if result:
				return result
			self.close()
		raise StopIteration

#------------------------------------------------------------------

cdef int check_open(opendir d) except -1:
	if not d.dir:
		raise ValueError("Directory is closed")
	return 0

