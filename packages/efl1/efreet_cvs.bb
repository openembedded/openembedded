DESCRIPTION = "An implementation of freedesktop.org specs for the \
Enlightenment Foundation Libraries"
DEPENDS = "ecore"
LICENSE = "BSD"
PV = "0.0.3.003+cvs${SRCDATE}"
PR = "r0"

inherit efl_library

PACKAGES =+ "${PN}-mime"
FILES_${PN}-mime = "${libdir}/libefreet_mime.so.*"

