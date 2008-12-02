require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- OMAP display driver"

PR ="r16"

SRCREV = "8915b62121b9528fbab55e0928028bce2b18b6e0"
PV = "0.0.1+${PR}+gitr${SRCREV}"
PE = "1"

SRC_URI = "git://git.pingu.fi/xf86-video-omapfb.git;protocol=http"

S = "${WORKDIR}/git"

CFLAGS += " -I${STAGING_INCDIR}/xorg "
