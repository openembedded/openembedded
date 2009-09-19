require xorg-driver-video.inc
SRC_URI = "git://git.bitwiz.org.uk/xf86-video-glamo.git;protocol=git;branch=master \
  file://0001-dpms.h-dpmsconst.h.patch;patch=1"

S = "${WORKDIR}/git"

PV="1.0.0+gitr${SRCPV}"
PR = "r2"

RDEPENDS = "xserver-xorg-extension-dri xserver-xorg-extension-dri2 xserver-xorg-extension-glx"

DESCRIPTION = "X.Org X server -- Glamo display driver"
