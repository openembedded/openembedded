require xorg-driver-video.inc
DEPENDS += "randrproto videoproto"

DESCRIPTION = "X.Org X server -- V4l2 overlay driver"
PV = "0.2.0+${PR}+gitr${SRCREV}"
PR = "${INC_PR}.0"

SRC_URI = "git://github.com/robclark/xf86-video-v4l2.git;protocol=git \
          "

SRCREV = "41a62fc2358255377a77"
S = "${WORKDIR}/git"

CFLAGS += " -I${STAGING_INCDIR}/xorg "
