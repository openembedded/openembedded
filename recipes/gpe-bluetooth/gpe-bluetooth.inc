DESCRIPTION = "GPE bluetooth support user interface tool."
SECTION = "gpe"
LICENSE = "GPL"
PRIORITY = "optional"
DEPENDS = "gtk+ libcontactsdb libdisplaymigration libgpewidget openobex libgpevtype bluez-libs sqlite dbus-glib libglade blueprobe bluez-utils-dbus"
RDEPENDS = "bluez-utils-dbus blueprobe"

GPE_TARBALL_SUFFIX= "bz2"
inherit gpe autotools

FILES_${PN} += '${datadir}/bluez-pin'
