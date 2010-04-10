DESCRIPTION = "Text editor with some IDE functionality"
HOMEPAGE = "http://geany.sf.net"
SECTION = "editors"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ vte"

inherit gnome

SRC_URI = "http://download.geany.org/geany-${PV}.tar.bz2 \
           file://no-bogus-cxx-check.diff;patch=1 \
"


SRC_URI[md5sum] = "d8e301f6933c828e2c36b3afdb3f4c34"
SRC_URI[sha256sum] = "7cb387d394b58b9ee1119dc6770b437e4a4c9e72b591b0bd431e54558f51212d"
