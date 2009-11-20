require gdb.inc
LICENSE = "GPLv3"

SRC_URI += "\
            file://gdb-6.8-fix-compile-karmic.patch;patch=1"

# Work-around problems while creating libbfd.a
EXTRA_OECONF += "--enable-static"
