require powertop.inc

PR = "${INC_PR}.1"

SRC_URI_append_armv7a = " file://omap.patch;patch=1;pnum=0"

CFLAGS_append_armv7a = " -DOMAP3"


SRC_URI[md5sum] = "3498f5983c683c3a57dce7379a722082"
SRC_URI[sha256sum] = "70e7cc53e5fbade5e447bda9f0ca12f2153bf426e074dbac3a2e97adf46180f2"
