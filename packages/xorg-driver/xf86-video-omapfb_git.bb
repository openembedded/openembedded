require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- OMAP display driver"

FILE_PR ="r10"

SRCREV = "7bf64be8e809d00c10c6bdae6933bdc71c642ea4"
PV = "0.0.1+${PR}+git${SRCREV}"

SRC_URI = "git://git.pingu.fi/xf86-video-omapfb.git;protocol=http"

S = "${WORKDIR}/git"

CFLAGS += " -I${STAGING_INCDIR}/xorg "
