require gdb-cross.inc

inherit sdk

DEPENDS = "ncurses-sdk zlib-sdk"

PR = "r3"

SRC_URI += "file://early_debug_in_nptl.patch;patch=1;pnum=0"

do_stage() {
	:
}
