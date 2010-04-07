DESCRIPTION = "freesmartphone.org monitor daemon"
AUTHOR = "freesmartphone.org development team"
SECTION = "console/network"
DEPENDS = "vala-native dbus dbus-glib"
LICENSE = "GPL"
SRCREV = "b4ae1e9b10e710042624c2cf1a15b91a7d5b1d44"
PV = "0.0.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/fso-monitord.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools update-rc.d

INITSCRIPT_NAME = "fso-monitord"
INITSCRIPT_PARAMS = "defaults 35"

FILES_${PN} += "${datadir} ${sysconfdir}"
