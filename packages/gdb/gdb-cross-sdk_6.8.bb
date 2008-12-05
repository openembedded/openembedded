require gdb-cross.inc

SRC_URI += "file://gcc-4.3-build-error.patch;patch=1;pnum=0"

DEPENDS = "ncurses-sdk"

inherit sdk

PR = "r2"

do_stage() {
	:
}
