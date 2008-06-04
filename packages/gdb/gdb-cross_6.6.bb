require gdb-cross.inc
inherit cross
PR = "r2"

SRC_URI += "file://sim-install-6.6.patch;patch=1 \
	    file://early_debug_in_nptl.patch;patch=1;pnum=0"


