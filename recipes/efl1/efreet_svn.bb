DESCRIPTION = "The Enlightenment freedesktop.org library"
DEPENDS = "ecore"
LICENSE = "MIT BSD"
PV = "0.5.0.050+svnr${SRCREV}"
PR = "r2"

inherit efl

DEBIAN_NOAUTONAME_${PN}-mime = "1"
DEBIAN_NOAUTONAME_${PN}-trash = "1"

PACKAGES =+ "${PN}-mime ${PN}-trash"
FILES_${PN}-mime = "${libdir}/libefreet_mime*.so.*"
FILES_${PN}-trash = "${libdir}/libefreet_trash*.so.*"
