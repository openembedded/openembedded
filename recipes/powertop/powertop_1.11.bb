require powertop.inc

PR = "${INC_PR}.1"

SRC_URI_append_armv7a = " file://omap.patch;patch=1;pnum=0"

CFLAGS_append_armv7a = " -DOMAP3"

