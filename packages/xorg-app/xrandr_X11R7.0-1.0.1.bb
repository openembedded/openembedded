LICENSE= "BSD-X"
DEPENDS = "libxrandr libx11 libxext"
DESCRIPTION = "X Resize and Rotate extension command."
SECTION = "x11/base"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/app/${PN}-X11R7.0-1.0.1.tar.bz2"
S = "${WORKDIR}/${PN}-X11R7.0-${PV}"

inherit autotools pkgconfig 
