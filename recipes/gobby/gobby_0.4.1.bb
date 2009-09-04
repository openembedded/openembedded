LICENSE = "LGPL"
HOMEPAGE = "http://darcs.0x539.de/trac/obby/cgi-bin/trac.cgi/wiki/"
PR = "r1"

DEPENDS = "net6 gtkmm obby gtksourceview1 libxml++"
inherit autotools pkgconfig

SRC_URI = "http://releases.0x539.de/gobby/gobby-${PV}.tar.gz"
