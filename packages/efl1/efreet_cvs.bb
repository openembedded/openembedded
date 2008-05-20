DESCRIPTION = "The Enlightenment freedesktop.org library"
DEPENDS = "ecore"
LICENSE = "MIT BSD"
PV = "0.5.0.043+cvs${SRCDATE}"
PR = "r0"

inherit efl

PACKAGES =+ "${PN}-mime"
FILES_${PN}-mime = "${libdir}/libefreet_mime.so.*"

