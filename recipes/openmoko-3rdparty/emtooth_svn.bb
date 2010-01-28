DESCRIPTION = "A bluetooth/bluez manager written in elementary for embedded systems"
AUTHOR = "Pau Espin Pedrol (Sharwin_F) <pespin.shar@gmail.com>"
HOMEPAGE = "http://code.google.com/p/emtooth/"
SECTION = "x11/applications"
LICENSE = "GPLv2"
DEPENDS = "elementary eina edbus"

SRCREV = "41"
PV = "0.1+svnr${SRCPV}"
PR = "r0"

SRC_URI = "svn://emtooth.googlecode.com/svn;module=trunk;proto=http"

S = "${WORKDIR}/trunk"

inherit pkgconfig autotools
