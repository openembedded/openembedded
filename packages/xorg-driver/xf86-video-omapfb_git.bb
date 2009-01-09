require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- OMAP display driver"

PR ="r17"

SRCREV = "8c7f8ba751997a65a8af1a83ade79b28b0b051fb"
PV = "0.0.1+${PR}+gitr${SRCREV}"
PE = "1"

SRC_URI = "git://git.pingu.fi/xf86-video-omapfb.git;protocol=http"

S = "${WORKDIR}/git"

CFLAGS += " -I${STAGING_INCDIR}/xorg "
