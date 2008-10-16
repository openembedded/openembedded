require hal.inc

SRC_URI += " file://hal-right-input-h.patch;patch=1"
EXTRA_OECONF += "--with-linux-input-header=${STAGING_INCDIR}/linux/input.h"
