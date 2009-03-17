require gdb-cross.inc

SRC_URI += "file://gcc-4.3-build-error.patch;patch=1;pnum=0"

inherit cross

PR = "r3"
