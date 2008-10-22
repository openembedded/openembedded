DESCRIPTION = "GSM 07.07 phone server"
HOMEPAGE = "http://www.freesmartphone.org/mediawiki/index.php/Implementations/gsm0710muxd"
AUTHOR = "Ixonos Team"
SECTION = "console/network"
DEPENDS = "dbus dbus-glib"
RDEPENDS = "gsm0710muxd"
LICENSE = "GPL"
PV = "0.1.0+${PR}-gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/gsmd2.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools

EXTRA_OECONF = "--disable-tests"

