DESCRIPTION = "A gtk-webcore based browser"
HOMEPAGE = "http://kazehakase.sourceforge.jp/"
SECTION = "x11/network"
LICENSE = "GPLv2"
DEPENDS = "osb-nrcit glib-2.0"
SRC_URI = "http://iij.dl.sourceforge.jp/kazehakase/25610/kazehakase-${PV}.tar.gz"

inherit autotools pkgconfig


SRC_URI[md5sum] = "44d7105f394b982661ba0567a0d23b90"
SRC_URI[sha256sum] = "0d52a80161b5dccfa904afd58dac4b5c79944943e7d81649459d2419362a014d"
