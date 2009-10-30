DESCRIPTION = "freesmartphone.org monitor daemon"
AUTHOR = "freesmartphone.org development team"
SECTION = "console/network"
DEPENDS = "vala-native dbus dbus-glib"
LICENSE = "GPL"
PV = "0.0.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/fso-monitord.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools update-rc.d

INITSCRIPT_NAME = "fso-monitord"
INITSCRIPT_PARAMS = "defaults 35"

FILES_${PN} += "${datadir} ${sysconfdir}"
