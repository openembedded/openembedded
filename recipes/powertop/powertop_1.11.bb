require powertop.inc

PR = "${INC_PR}.0"

SRC_URI_append_armv7a = " file://omap.patch;patch=1;pnum=0"

CFLAGS_append_beagleboard = " -DOMAP3"
CFLAGS_append_overo = " -DOMAP3"
CFLAGS_append_omap3evm = " -DOMAP3"
CFLAGS_append_omapzoom2 = " -DOMAP3"
