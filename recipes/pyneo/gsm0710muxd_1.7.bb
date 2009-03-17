DESCRIPTION = "gsm 07.10 muxer userspace daemon"
HOMEPAGE = "http://pyneo.org/muxer"
AUTHOR = "M. Dietrich"
LICENSE = "GPL3"
SECTION = "console/network"
DEPENDS = "dbus dbus-glib intltool-native"
PR = "r6"

SRC_URI = "http://pyneo.org/downloads/${PN}-${PV}.tgz"

inherit autotools update-rc.d

INITSCRIPT_NAME = "gsm0710muxd"
INITSCRIPT_PARAMS = "defaults 55"

FILES_${PN} += "${datadir} ${sysconfdir}"

RDEPENDS = "dbus dbus-glib"
RCONFLICTS = "gsmmux fso-gsm0710muxd"
RREPLACES = "gsmmux"

