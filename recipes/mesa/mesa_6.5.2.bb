include mesa-mesa.inc

PR = "${INC_PR}.0"

SRC_URI_append = " file://fix-host-compile.patch;patch=1 "

SRC_URI[md5sum] = "e4d894181f1859651658b3704633e10d"
SRC_URI[sha256sum] = "137f50a30461d51eb9af5aac737bc788d536354cf47b26129b97bde6e41fb85f"
