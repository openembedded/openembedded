DESCRIPTION = "freesmartphone.org API GLib wrapper (auto-generated)"
SECTION = "devel"
LICENSE = "LGPL-3"
DEPENDS = "dbus-glib"
SRCREV = "133dc094f98e772e89949b4e35002ab5c1f2d7e2"
PV = "0.2+gitr${SRCPV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/libfreesmartphone-glib.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools pkgconfig
