require gdb.inc
LICENSE = "GPLv3"

PR = "${INC_PR}.0"
# there is a bug in GCC for SH4 it ICE's at Optlevel >O1
# so workaround that for now.

CFLAGS_append_sh4 = " -O1"
SRC_URI += "file://gdb-6.8-fix-compile-karmic.patch \
	    file://gdb-tcsetpgrp.patch \
	    file://gdb-fix-sim-ppc.patch \
	    file://renesas-sh-native-support.patch \
	   "

# Work-around problems while creating libbfd.a
EXTRA_OECONF += "--enable-static"
SRC_URI[md5sum] = "950b766466bee748e554765c86b8b495"
SRC_URI[sha256sum] = "34919cb51334c8149ae36ed086f35e79fe3fa2b2a85b568d7c0edad20cd972d4"

