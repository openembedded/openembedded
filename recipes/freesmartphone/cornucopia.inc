DESCRIPTION = "The freesmartphone.org API reference implementation (FSO 2.0)"
AUTHOR = "Team FSO"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "vala-native glib-2.0 dbus dbus-glib libfso-glib"
PV = "0.0.0.0+gitr${SRCREV}"
INC_PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/cornucopia;protocol=git;branch=master"
S = "${WORKDIR}/git/${PN}"

inherit autotools_stage pkgconfig vala

FILES_${PN} += "${sysconfdir} ${datadir}/${PN}"
