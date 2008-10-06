require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- OMAP display driver"

SRCREV = "eb05e4446877409b349d8f9ede35052cc7a3432b"
PV = "0.0.1+${PR}+git${SRCREV}"

SRC_URI = "git://git.pingu.fi/xf86-video-omapfb.git;protocol=http"

S = "${WORKDIR}/git"

