LICENSE = "MIT"
DESCRIPTION = "utility for modifying keymaps and pointer button mappings in X"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "x11/base"

DEPENDS = "libx11"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/app/${PN}-X11R7.0-1.0.0.tar.bz2"
S = "${WORKDIR}/${PN}-X11R7.0-${PV}"

inherit autotools pkgconfig 
