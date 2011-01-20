DESCRIPTION = "High Level DBus Introspection Daemon"
HOMEPAGE = "http://www.freesmartphone.org/mediawiki/index.php/Implementations/DbusHlid"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
DEPENDS = "vala-native dbus dbus-glib"
LICENSE = "GPL"
SRCREV = "154652fdbd2cf68e03a3c91c49ff2ece8ffd7288"
PV = "1.0.1+gitr${SRCPV}"
PE = "1"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/dbus-hlid.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools

FILES_${PN} += "${datadir} ${sysconfdir}"
