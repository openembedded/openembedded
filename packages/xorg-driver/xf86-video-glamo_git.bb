require xorg-driver-video.inc
SRC_URI = "git://git.openmoko.org/git/xglamo.git;protocol=git;branch=xora/xorg-driver"
PV = "0.1+gitr${SRCREV}"
PE = "1"

DESCRIPTION = "X.Org X server -- fbdev display driver"

S = "${WORKDIR}/git"

