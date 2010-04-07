DESCRIPTION = "High Level DBus Introspection Daemon"
HOMEPAGE = "http://www.freesmartphone.org/mediawiki/index.php/Implementations/DbusHlid"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
DEPENDS = "vala-native dbus dbus-glib"
LICENSE = "GPL"
SRCREV = "5df7f49fe8881804aaab544a569fd164c3e93afb"
PV = "1.0.1+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/dbus-hlid.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools

FILES_${PN} += "${datadir} ${sysconfdir}"
