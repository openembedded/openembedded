DESCRIPTION = "FSO monitor daemon"
AUTHOR = "M. Lauer et. al."
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

RDEPENDS_${PN} = "frameworkd"

FILES_${PN} += "${datadir} ${sysconfdir}"
