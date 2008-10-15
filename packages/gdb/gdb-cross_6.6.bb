require gdb-cross.inc
inherit cross

FILE_PR = "r3"

SRC_URI += "file://early_debug_in_nptl.patch;patch=1;pnum=0"

