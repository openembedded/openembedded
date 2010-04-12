DESCRIPTION = "A gtk-webcore based browser"
HOMEPAGE = "http://kazehakase.sourceforge.jp/"
SECTION = "x11/network"
LICENSE = "GPLv2"
DEPENDS = "osb-nrcit glib-2.0"
SRC_URI = "http://osdn.dl.sourceforge.jp/kazehakase/24791/kazehakase-${PV}.tar.gz"

inherit autotools pkgconfig


SRC_URI[md5sum] = "2171f02d58a575e148436c7102686afb"
SRC_URI[sha256sum] = "87ad1345e1d6df6ffdb1b43af92cfd87a16eade7de4060c5ce2fabd4d37bf99a"
