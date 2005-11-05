LICENSE = "GPL"
inherit gpe autotools

DESCRIPTION = "GPE bluetooth support"
DEPENDS = "gtk+ libdisplaymigration libgpewidget openobex libgpevtype bluez-libs sqlite dbus libglade blueprobe bluez-utils-dbus"
RDEPENDS = "bluez-utils-dbus blueprobe"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SECTION = "gpe"
PRIORITY = "optional"
PR = "r0"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2"

FILES_${PN} += '${datadir}/bluez-pin'

