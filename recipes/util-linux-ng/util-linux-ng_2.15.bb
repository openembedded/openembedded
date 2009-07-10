require util-linux-ng.inc

PR = "${INC_PR}"

SRC_URI += "file://fix-make-c.patch;patch=1 \
            file://optional-uuid.patch;patch=1 \
            file://uclibc-compile.patch;patch=1 \
"

LDFLAGS_append = " -luuid"
LDFLAGS_append_libc-uclibc = " -luuid -lintl"

do_compile_prepend() {
	sed -i /am__append_1/d ${S}/libs/blkid/src/Makefile
}
