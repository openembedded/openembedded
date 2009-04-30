DESCRIPTION = "freesmartphone.org API glib wrapper"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "dbus-glib"
PV = "0.0.2+gitr${SRCPV}"
PR = "r0"
PV = "1"

SRC_URI = "${FREESMARTPHONE_GIT}/libframeworkd-glib.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools autotools_stage pkgconfig
