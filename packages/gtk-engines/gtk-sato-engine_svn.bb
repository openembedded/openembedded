LICENSE = "GPL"
SECTION = "x11/base"
DESCRIPTION = "GTK theme engine SATO from O-Hand"
DEPENDS = "gtk+"

PV = "0.0.1+svn${SRCDATE}"
PR = "r0"

PACKAGES += "gtk-theme-sato"
FILES_${PN} = "${libdir}/gtk-2.0/*/engines/*.so"
FILES_${PN}-dev = "${libdir}/gtk-2.0/*/engines/*"
FILES_gtk-theme-sato = "${datadir}/icons ${datadir}/themes"

S = "${WORKDIR}/gtk-engine"

SRC_URI = "svn://svn.o-hand.com/repos/sato/trunk;module=gtk-engine;proto=http"

inherit autotools pkgconfig
