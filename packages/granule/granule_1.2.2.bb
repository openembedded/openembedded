DESCRIPTION = "Generic memory training with flash cards.  Automatic scheduling algorithm."
AUTHOR = "Vladislav Grinchenko <vlg@users.sourceforge.net>"
HOMEPAGE = "http://granule.sf.net"
SECTION = "x11/apps"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "glib-2.0-native intltool-native gtkmm libxml2 libassa"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig
