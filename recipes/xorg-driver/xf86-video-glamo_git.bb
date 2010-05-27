require xorg-driver-video.inc
SRC_URI = "git://git.openmoko.org/git/xf86-video-glamo.git;protocol=git;branch=master"

S = "${WORKDIR}/git"

SRCREV = "a5ef0525ab34d7d5590aba51651ae1a6f40858bc"
PV = "1.0.0+gitr${SRCPV}"
PE = "2"
PR = "r5"

RDEPENDS = "xserver-xorg-extension-dri xserver-xorg-extension-dri2 xserver-xorg-extension-glx mesa-dri"
DEPENDS += "libdrm"

DESCRIPTION = "X.Org X server -- Glamo display driver with KMS support"

EXTRA_OECONF = " --enable-kms "
