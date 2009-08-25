require gdb-canadian-cross.inc
LICENSE = "GPLv3"

SRC_URI += "file://gcc-4.3-build-error.patch;patch=1;pnum=0 \
	    file://gdb-6.8-mingw-3.patch;patch=1 \
	    file://gdb-6.8-pr9638-ppc-canadian-configh.patch;patch=1 \
	    file://gdb-6.8-fix-compile-karmic.patch;patch=1 \
	    file://gdb-6.8-mips-mingw-sim-fixup.patch;patch=1"

PR = "r1"

do_stage() {
	:
}
