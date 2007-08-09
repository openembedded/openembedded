LICENSE = "GPL"
SECTION = "x11/base"
DESCRIPTION = "GTK theme engine SATO from O-Hand"
DEPENDS = "gtk+"

DEFAULT_PREFERENCE = "-1"

PV = "0.1+svn${SRCDATE}"
PR = "r0"

S = "${WORKDIR}/gtk-engine"

SRC_URI = "svn://svn.o-hand.com/repos/sato/trunk;module=gtk-engine;proto=http"

inherit autotools pkgconfig

PACKAGES += "gtk-theme-sato"
FILES_${PN} = "${libdir}/gtk-2.0/*/engines/*.so "
FILES_${PN}-dev = "${libdir}/gtk-2.0/*/engines/*"
FILES_${PN}-dbg = "${libdir}/gtk-2.0/*/engines/.debug"
FILES_gtk-theme-sato = "${datadir}/icons ${datadir}/themes"

RDEPENDS_gtk-theme-sato = "${PN}"


