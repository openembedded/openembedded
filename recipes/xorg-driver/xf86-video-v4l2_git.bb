require xorg-driver-video.inc
DEPENDS += "randrproto videoproto"

DESCRIPTION = "X.Org X server -- V4l2 overlay driver"
PV = "0.2.0+${PR}+gitr${SRCREV}"
PR = "${INC_PR}.1"

SRC_URI = "git://github.com/robclark/xf86-video-v4l2.git;protocol=git \
          "

SRCREV = "ec9f3c2348d33a378e5a0c813da368d1193d76d4"
S = "${WORKDIR}/git"

CFLAGS += " -I${STAGING_INCDIR}/xorg "
