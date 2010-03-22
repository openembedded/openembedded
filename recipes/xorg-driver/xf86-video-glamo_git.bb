require xorg-driver-video.inc
SRC_URI = "git://git.openmoko.org/git/xf86-video-glamo.git;protocol=git;branch=master"

S = "${WORKDIR}/git"

SRCREV = "77b6d1b7363d3ff28f063ed92c9ed47194f70b20"
PV = "1.0.0+gitr${SRCREV}"
PE = "1"
PR = "r3"

do_configure_prepend() {
  # pedantic emits warning about GCC extension used in xserver header file edid.h (from version 1.8) and because of -Werror it fill fail
  sed -i 's/ -pedantic / /g' ${S}/src/Makefile.am
}

RDEPENDS = "xserver-xorg-extension-dri xserver-xorg-extension-dri2 xserver-xorg-extension-glx mesa-dri"
DEPENDS += "libdrm"

DESCRIPTION = "X.Org X server -- Glamo display driver with KMS support"

EXTRA_OECONF = " --enable-kms "
