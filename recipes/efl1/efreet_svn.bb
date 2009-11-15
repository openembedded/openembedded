DESCRIPTION = "The Enlightenment freedesktop.org library"
DEPENDS = "ecore"
LICENSE = "MIT BSD"
PV = "0.5.0.060+svnr${SRCPV}"
PR = "r1"

inherit efl

PACKAGES =+ "${PN}-mime ${PN}-trash"
FILES_${PN}-mime = "${libdir}/libefreet_mime.so.*"
FILES_${PN}-trash = "${libdir}/libefreet_trash.so.*"
