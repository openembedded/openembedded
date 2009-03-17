DESCRIPTION = "GSM 07.07 phone server"
HOMEPAGE = "http://www.freesmartphone.org/mediawiki/index.php/Implementations/gsmd2"
AUTHOR = "Ixonos Team"
SECTION = "console/network"
DEPENDS = "dbus dbus-glib"
LICENSE = "GPL"
PV = "0.1.0+gitr${SRCREV}"
PR = "r1"

SRC_URI = "${FREESMARTPHONE_GIT}/gsmd2.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools

EXTRA_OECONF = "--disable-tests"

RDEPENDS = "fso-gsm0710muxd"
