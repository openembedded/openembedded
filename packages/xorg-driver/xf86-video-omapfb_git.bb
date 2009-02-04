require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- OMAP display driver"

PR ="r20"

SRCREV = "ef0b41c332a710fb33f996df77bd4a96b56878da"
PV = "0.0.1+${PR}+gitr${SRCREV}"
PE = "1"

SRC_URI = "git://git.pingu.fi/xf86-video-omapfb.git;protocol=http \
          "

SRC_URI_append_armv7a = " file://omapfb-neon.diff;patch=1"

S = "${WORKDIR}/git"

CFLAGS += " -I${STAGING_INCDIR}/xorg "
