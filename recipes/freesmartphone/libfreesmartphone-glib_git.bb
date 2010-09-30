DESCRIPTION = "freesmartphone.org API GLib wrapper (auto-generated)"
SECTION = "devel"
LICENSE = "LGPL-3"
DEPENDS = "dbus-glib"
SRCREV = "51e786fd4c34e9391a895353449f19deaeae7783"
PV = "0.2+gitr${SRCPV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/libfreesmartphone-glib.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools pkgconfig
