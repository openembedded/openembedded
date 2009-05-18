require util-linux-ng.inc

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/util-linux-ng-2.15', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

LDFLAGS_append_libc-uclibc = " -lintl"

