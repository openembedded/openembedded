require xorg-driver-video.inc
SRC_URI = "git://git.openmoko.org/git/xf86-video-glamo.git;protocol=git;branch=master"

S = "${WORKDIR}/git"

SRCREV = "9918e082104340da42eb92b6bdefce4d9266a6a4"
PV = "1.0.0+gitr${SRCREV}"
PE = "1"
PR = "r3"

RDEPENDS = "xserver-xorg-extension-dri xserver-xorg-extension-dri2 xserver-xorg-extension-glx mesa-dri"
DEPENDS += "libdrm"

DESCRIPTION = "X.Org X server -- Glamo display driver with KMS support"

EXTRA_OECONF = " --enable-kms "
