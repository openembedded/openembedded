require xorg-driver-video.inc
SRC_URI = "git://git.openmoko.org/git/xf86-video-glamo.git;protocol=git;branch=master \
           file://remove_deprecated.patch"

S = "${WORKDIR}/git"

SRCREV = "2d96367657adb21b34742e76c3a92ba1a3961106"
PV = "1.0.0+gitr${SRCPV}"
PE = "2"

RDEPENDS_${PN} = "xserver-xorg-extension-dri xserver-xorg-extension-dri2 xserver-xorg-extension-glx mesa-dri"
DEPENDS += "libdrm"

DESCRIPTION = "X.Org X server -- Glamo display driver with KMS support"

EXTRA_OECONF = " --enable-kms "
PR = "${INC_PR}.1"
