require xorg-driver-video.inc
SRC_URI = "git://git.openmoko.org/git/xf86-video-glamo;protocol=git;branch=master"
PV = "0.1+gitr${SRCREV}"
PE = "1"

DESCRIPTION = "X.Org X server -- fbdev display driver"

S = "${WORKDIR}/git"

ARM_INSTRUCTION_SET = "arm"

