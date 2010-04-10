LICENSE = "LGPL"
HOMEPAGE = "http://darcs.0x539.de/trac/obby/cgi-bin/trac.cgi/wiki/"
PR = "r1"

DEPENDS = "net6 gtkmm obby gtksourceview1 libxml++"
inherit autotools pkgconfig

SRC_URI = "http://releases.0x539.de/gobby/gobby-${PV}.tar.gz"

SRC_URI[md5sum] = "a2c79bdda652a2d74fec104235d27bc0"
SRC_URI[sha256sum] = "aad2ed23638f5a6aa655dc13395228cefc4c28e46b05eb05ac12481fac36aba3"
