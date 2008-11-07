require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- OMAP display driver"

PR ="r12"

SRCREV = "c1d44a1b11bb4e60331dd39f2deb9b3df9149e37"
PV = "0.0.1+${PR}+git${SRCREV}"

SRC_URI = "git://git.pingu.fi/xf86-video-omapfb.git;protocol=http"

S = "${WORKDIR}/git"

CFLAGS += " -I${STAGING_INCDIR}/xorg "
