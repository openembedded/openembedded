DESCRIPTION = "High Level DBus Introspection Daemon"
AUTHOR = "M. Lauer"
SECTION = "console/network"
DEPENDS = "vala dbus dbus-glib"
LICENSE = "GPL"
PV = "0.9.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/dbus-hlid.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools

FILES_${PN} += "${datadir} ${sysconfdir}"
