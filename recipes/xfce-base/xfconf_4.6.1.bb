DESCRIPTION = "Xfce configuration daemon and utilities"
HOMEPAGE = "http://www.xfce.org"
SECTION = "x11/wm"
LICENSE = "GPL-2"

DEPENDS = "libxfce4util"
RDEPENDS_${PN} = "libxfce4util"

PR = "r3"

inherit xfce46

FILES_${PN} += "${datadir}/dbus-1/services/org.xfce.Xfconf.service"

SRC_URI[md5sum] = "d4d3018767ea9eb4b57cc57d4038023b"
SRC_URI[sha256sum] = "22a596f73795be398382e82e9c11062423daa374339ce6db808f73a6ba19380e"
