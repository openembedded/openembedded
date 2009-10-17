require xorg-driver-video.inc
SRC_URI = "git://git.openmoko.org/git/xf86-video-glamo.git;protocol=git;branch=kms \
           file://0001-Check-pScrn-variable-before-usage.patch;patch=1"

PROVIDES = "xf86-video-glamo"

S = "${WORKDIR}/git"

PV=1.0.0+gitr${SRCREV}
PR = "r1"

RDEPENDS = "xserver-xorg-extension-dri xserver-xorg-extension-dri2 xserver-xorg-extension-glx mesa-dri"

DESCRIPTION = "X.Org X server -- Glamo display driver with KMS support"
