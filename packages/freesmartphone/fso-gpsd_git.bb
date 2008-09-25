DESCRIPTION = "gspd compatibility layer for frameworkd"
LICENSE = "GPL"
SECTION = "network"
DEPENDS = "dbus-glib"
PV = "0.6+${PR}+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/fso-gpsd.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools

RPROVIDES_${PN} = "gpsd"
RCONFLICTS_${PN} = "gpsd"
RREPLACES_${PN} = "gpsd"
