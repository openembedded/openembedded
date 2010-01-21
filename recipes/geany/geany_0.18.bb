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

