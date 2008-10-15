require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- OMAP display driver"

FILE_PR ="r7"

SRCREV = "f488430a2bf036c61243322584026e786284d3a7"
PV = "0.0.1+${PR}+git${SRCREV}"

SRC_URI = "git://git.pingu.fi/xf86-video-omapfb.git;protocol=http"

S = "${WORKDIR}/git"

CFLAGS += " -I${STAGING_INCDIR}/xorg "
