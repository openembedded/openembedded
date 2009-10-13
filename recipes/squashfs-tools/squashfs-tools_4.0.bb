require squashfs-tools.inc
PR = "${INC_PR}.1"

DEFAULT_PREFERENCE = "-1"
SRC_URI += " file://Makefile.patch;patch=1"
