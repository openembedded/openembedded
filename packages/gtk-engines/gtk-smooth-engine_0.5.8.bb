PR = "r0"
LICENSE = "LGPL"
SECTION = "x11/base"
DESCRIPTION = "GTK theme engine Smooth"
DEPENDS = "gtk+"

FILES_${PN} = "${libdir}/gtk-2.0/2.4.0/engines/libsmooth.so"

SRC_URI = "${SOURCEFORGE_MIRROR}/smooth-engine/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig
