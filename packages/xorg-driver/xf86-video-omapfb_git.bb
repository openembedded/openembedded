require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- OMAP display driver"

PR ="r8"

SRCREV = "9a4fe691d60ac29e510dfa5180bd799ead86d1d5"
PV = "0.0.1+${PR}+git${SRCREV}"

SRC_URI = "git://git.pingu.fi/xf86-video-omapfb.git;protocol=http"

S = "${WORKDIR}/git"

CFLAGS += " -I${STAGING_INCDIR}/xorg "
