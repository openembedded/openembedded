require gdb-cross.inc
LICENSE = "GPLv3"

SRC_URI += "\
            file://gdb-6.8-fix-compile-karmic.patch;patch=1"

DEPENDS = "ncurses-sdk zlib-sdk"

inherit sdk

do_stage() {
	:
}
