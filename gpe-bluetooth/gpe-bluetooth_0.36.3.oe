LICENSE = "GPL"
inherit gpe

DESCRIPTION = "GPE bluetooth support"
DEPENDS = "gtk+ libdisplaymigration libgpewidget openobex libgpevtype bluez-libs sqlite dbus libglade blueprobe"
RDEPENDS = "bluez-utils blueprobe"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SECTION = "gpe"
PRIORITY = "optional"
PR = "r3"

SRC_URI += "file://segfault.patch;patch=1;pnum=0"

FILES_${PN} += '${datadir}/bluez-pin'

