require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- OMAP display driver"

PR ="r11"

SRCREV = "da20e7edbff31ac0a5a496af947424b0991a36be"
PV = "0.0.1+${PR}+git${SRCREV}"

SRC_URI = "git://git.pingu.fi/xf86-video-omapfb.git;protocol=http"

S = "${WORKDIR}/git"

CFLAGS += " -I${STAGING_INCDIR}/xorg "
