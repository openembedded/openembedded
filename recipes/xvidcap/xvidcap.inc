DESCRIPTION = "Capture X-Window display to individual frames or MPEG video."
SECTION = "multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Rasca <thron@gmx.de> Karl H. Beckers <karl.h.beckers@gmx.net>"
HOMEPAGE = "http://xvidcap.sf.net"

DEPENDS = "intltool-native docbook-utils-native gtk+ glib-2.0 libglade lame libxmu libxfixes libxdamage"

INC_PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools

EXTRA_OECONF = "--enable-libmp3lame --with-x"

FILES_${PN} += "${datadir}/dbus-1"
