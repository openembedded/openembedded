LICENSE = "GPL"
DESCRIPTION = "GPE bluetooth support"
SECTION = "gpe"
PRIORITY = "optional"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"

DEPENDS = "gtk+ libdisplaymigration libgpewidget openobex libgpevtype bluez-libs sqlite dbus libglade blueprobe bluez-utils-dbus libcontactsdb"
RDEPENDS = "bluez-utils-dbus blueprobe"

GPE_TARBALL_SUFFIX= "bz2"
inherit gpe autotools

FILES_${PN} += '${datadir}/bluez-pin'
