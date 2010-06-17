DESCRIPTION = "Xfce configuration daemon and utilities"
HOMEPAGE = "http://www.xfce.org"
SECTION = "x11/wm"
LICENSE = "GPL-2"

DEPENDS = "libxfce4util"
RDEPENDS_${PN} = "libxfce4util"

PR = "r0"

inherit xfce46

FILES_${PN} += "${datadir}/dbus-1/services/org.xfce.Xfconf.service"

SRC_URI[md5sum] = "5ff93c15077c6dbbcd38c437bc1ab2ef"
SRC_URI[sha256sum] = "7b2635abc33ae6a76145238ed27557bc1ff91b1a5ee0757962f798a66d56f478"
