require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- OMAP display driver"

PR ="r14"

SRCREV = "e33601fe4c4c5e0d093321f86a633047056c7445"
PV = "0.0.1+${PR}+gitr${SRCREV}"
PE = "1"

SRC_URI = "git://git.pingu.fi/xf86-video-omapfb.git;protocol=http"

S = "${WORKDIR}/git"

CFLAGS += " -I${STAGING_INCDIR}/xorg "
