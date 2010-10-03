require gdb.inc
LICENSE = "GPLv3"

PR = "${INC_PR}.4"
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

SRC_URI[md5sum] = "01a6ce13bab5307cfac5c405e4afd1cf"
SRC_URI[sha256sum] = "fc839b5226b94e58a5c7a526e67b7f8f93c7829d05dae1b6247f1bfe3829f291"
