require xorg-driver-video.inc
SRC_URI = "git://git.openmoko.org/git/xf86-video-glamo.git;protocol=git;branch=master"

S = "${WORKDIR}/git"

SRCREV = "e43cf499d0df41eb6ca2a1a7c21af71e31207635"
PV = "1.0.0+gitr${SRCPV}"
PE = "2"

RDEPENDS_${PN} = "xserver-xorg-extension-dri xserver-xorg-extension-dri2 xserver-xorg-extension-glx mesa-dri"
DEPENDS += "libdrm"

DESCRIPTION = "X.Org X server -- Glamo display driver with KMS support"

EXTRA_OECONF = " --enable-kms "
PR = "${INC_PR}.2"
