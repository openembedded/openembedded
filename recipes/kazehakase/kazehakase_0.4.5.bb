DESCRIPTION = "A gtk-webcore based browser"
HOMEPAGE = "http://kazehakase.sourceforge.jp/"
SECTION = "x11/network"
LICENSE = "GPLv2"
DEPENDS = "osb-nrcit glib-2.0"
SRC_URI = "http://osdn.dl.sourceforge.jp/kazehakase/24791/kazehakase-${PV}.tar.gz"

inherit autotools pkgconfig

