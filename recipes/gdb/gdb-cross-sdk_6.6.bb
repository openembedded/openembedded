require gdb-cross.inc
LICENSE = "GPLv2"

inherit sdk

DEPENDS = "ncurses-sdk zlib-sdk flex-native"

PR = "r3"

SRC_URI += "file://early_debug_in_nptl.patch;patch=1;pnum=0"

do_stage() {
	:
}
