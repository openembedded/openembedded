LICENSE = "GPL"
inherit gpe

DESCRIPTION = "GPE bluetooth support"
DEPENDS = "gtk+ libdisplaymigration libgpewidget openobex libgpevtype bluez-libs sqlite dbus libglade blueprobe bluez-utils-dbus"
RDEPENDS = "bluez-utils-dbus blueprobe"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SECTION = "gpe"
PRIORITY = "optional"
PR = "r0"

FILES_${PN} += '${datadir}/bluez-pin'

