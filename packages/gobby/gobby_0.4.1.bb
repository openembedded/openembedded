LICENSE = "LGPL"
HOMEPAGE = "http://darcs.0x539.de/trac/obby/cgi-bin/trac.cgi/wiki/"
MAINTAINER = "Patrick Steiner <patrick.steiner@a1.net>"

DEPENDS = "net6 gtkmm obby gtksourceview libxml++"
inherit autotools pkgconfig

SRC_URI = "http://releases.0x539.de/gobby/gobby-${PV}.tar.gz"
