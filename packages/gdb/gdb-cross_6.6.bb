require gdb-cross.inc

SRC_URI += "file://sim-install-6.6.patch;patch=1"
SRC_URI += "file://early_debug_in_nptl.patch;patch=1;pnum=0"

inherit cross

PR = "r2"
