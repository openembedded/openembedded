require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- Glamo display driver with KMS support"
DEPENDS += "libdrm"
RDEPENDS_${PN} = "xserver-xorg-extension-dri xserver-xorg-extension-dri2 xserver-xorg-extension-glx mesa-dri"
PE = "2"
PV = "1.0.0+gitr${SRCPV}"
PR = "${INC_PR}.2"

SRC_URI = "git://git.openmoko.org/git/xf86-video-glamo.git;protocol=git;branch=master"

S = "${WORKDIR}/git"
SRCREV = "e43cf499d0df41eb6ca2a1a7c21af71e31207635"

EXTRA_OECONF = " --enable-kms "
