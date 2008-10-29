require hal.inc

PR = "r1"

SRC_URI += " file://hal-right-input-h.patch;patch=1 \
             file://fix-configure.diff;patch=1"

EXTRA_OECONF += "--with-linux-input-header=${STAGING_INCDIR}/linux/input.h"
