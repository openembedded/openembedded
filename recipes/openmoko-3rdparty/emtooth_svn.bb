DESCRIPTION = "A bluetooth/bluez manager written in elementary for embedded systems"
AUTHOR = "Pau Espin Pedrol (Sharwin_F) <pespin.shar@gmail.com>"
HOMEPAGE = "http://code.google.com/p/emtooth/"
SECTION = "x11/applications"
LICENSE = "GPLv2"
DEPENDS = "elementary eina edbus"

SRCREV = "46"
PV = "0.1+svnr${SRCPV}"
PR = "r0"

SRC_URI = "svn://emtooth.googlecode.com/svn/trunk;module=app;proto=http"

S = "${WORKDIR}/app"

inherit pkgconfig autotools
