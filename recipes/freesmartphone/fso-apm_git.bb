DESCRIPTION = "freesmartphone.org apm compatibility utility"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
HOMEPAGE = "http://www.freesmartphone.org"
SECTION = "console"
LICENSE = "GPLv2"
DEPENDS = "vala-native"
RCONFLICTS = "apm"
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PV = "2.0.0+gitr${SRCREV}"
PR = "r1"

SRC_URI = "${FREESMARTPHONE_GIT}/cornucopia.git;protocol=git;branch=master"
S = "${WORKDIR}/git/tools/apm2"

inherit autotools


