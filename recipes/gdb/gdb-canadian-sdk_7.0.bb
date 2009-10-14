require gdb-canadian-cross.inc
LICENSE = "GPLv3"

SRC_URI += "\
	    file://gdb-6.8-mingw-3.patch;patch=1 \
	    file://gdb-6.8-pr9638-ppc-canadian-configh.patch;patch=1 \
	    file://gdb-6.8-fix-compile-karmic.patch;patch=1 \
	    "
do_stage() {
	:
}
