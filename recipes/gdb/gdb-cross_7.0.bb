require gdb-cross.inc
LICENSE = "GPLv3"

SRC_URI += " \
            file://gdb-6.8-fix-compile-karmic.patch;patch=1"

inherit cross
