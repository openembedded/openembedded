LICENSE = "GPL"
DESCRIPTION = "GPE bluetooth support"
SECTION = "gpe"
PRIORITY = "optional"
PR = "r1"

DEPENDS = "gtk+ libcontactsdb libdisplaymigration libgpewidget openobex libgpevtype bluez-libs sqlite dbus libglade blueprobe bluez-utils-dbus"
RDEPENDS = "bluez-utils-dbus blueprobe"

GPE_TARBALL_SUFFIX= "bz2"
inherit gpe autotools

SRC_URI += "file://fix-resume-script-name.patch;patch=1"

FILES_${PN} += '${datadir}/bluez-pin'
