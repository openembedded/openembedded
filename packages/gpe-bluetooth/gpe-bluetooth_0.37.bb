LICENSE = "GPL"
inherit gpe

DESCRIPTION = "GPE bluetooth support"
DEPENDS = "gtk+ libdisplaymigration libgpewidget openobex libgpevtype bluez-libs sqlite dbus libglade blueprobe bluez-utils-dbus"
RDEPENDS = "bluez-utils-dbus blueprobe"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SECTION = "gpe"
PRIORITY = "optional"
PR = "r7"

FILES_${PN} += '${datadir}/bluez-pin'

SRC_URI += "file://change-sdp-to-bluetooth.patch;patch=1 \
	file://icon-resize.patch;patch=1 \
	file://hciattach-path.patch;patch=1 \
	file://dbus-service-name.patch;patch=1"
