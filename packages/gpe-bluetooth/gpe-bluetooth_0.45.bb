LICENSE = "GPL"
inherit gpe autotools

DESCRIPTION = "GPE bluetooth support"
DEPENDS = "gtk+ libdisplaymigration libgpewidget openobex libgpevtype bluez-libs sqlite dbus libglade blueprobe bluez-utils-dbus"
RDEPENDS = "bluez-utils-dbus blueprobe"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SECTION = "gpe"
PRIORITY = "optional"
PR = "r1"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2 \
	   file://bluez-pin-gpe.glade"

FILES_${PN} += '${datadir}/bluez-pin'

do_install_append() {
install -d ${D}${datadir}/bluez-pin
install -m 644 ${WORKDIR}/bluez-pin-gpe.glade ${D}${datadir}/bluez-pin/

}

