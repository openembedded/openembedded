DESCRIPTION = "High Level DBus Introspection Daemon"
AUTHOR = "M. Lauer et. al."
SECTION = "console/network"
DEPENDS = "vala-native dbus dbus-glib"
LICENSE = "GPL"
PV = "0.9.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/dbus-hlid.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools

FILES_${PN} += "${datadir} ${sysconfdir}"
