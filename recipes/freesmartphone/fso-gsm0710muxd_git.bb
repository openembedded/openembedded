DESCRIPTION = "GSM 07.10 muxer userspace daemon (FSO Branch)"
HOMEPAGE = "http://www.freesmartphone.org/mediawiki/index.php/Implementations/gsm0710muxd"
SECTION = "console/network"
DEPENDS = "dbus dbus-glib"
LICENSE = "GPL"
SRCREV = "1d69fb5b666ac2a9e54e46978c7afa8fe5dfc3c9"
PV = "0.9.3.1+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/gsm0710muxd.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools

RDEPENDS = "dbus dbus-glib"
RCONFLICTS = "gsm0710muxd"
RREPLACES = "gsm0710muxd"

FILES_${PN} += "${datadir} ${sysconfdir}"
