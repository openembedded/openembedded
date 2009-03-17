require util-linux-ng.inc

PR = "r3"
FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/util-linux-ng-2.14', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

SRC_URI += "file://util-linux-ng-uclibc-versionsort.patch;patch=1 \
	   "
LDFLAGS_append_linux-uclibc = " -lintl"
LDFLAGS_append_linux-uclibcgnueabi = " -lintl "
LDFLAGS_append_uclinux-uclibc = " -lintl"

