DESCRIPTION = "freesmartphone.org API glib wrapper"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "dbus-glib"
SRCREV = "95a266d3ffa17352792d59d16ff8671898d445a2"
PV = "0.0.1+gitr${SRCPV}"
PE = "1"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/libframeworkd-glib.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

