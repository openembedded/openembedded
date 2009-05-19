require util-linux-ng.inc

PR = "r2"

SRC_URI += "file://fix-make-c.patch;patch=1 \
            file://optional-uuid.patch;patch=1 \
"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/util-linux-ng-2.15', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

LDFLAGS_append = " -luuid"
LDFLAGS_append_libc-uclibc = " -luuid -lintl"

do_compile_prepend() {
	sed -i /am__append_1/d ${S}/libs/blkid/src/Makefile
}
