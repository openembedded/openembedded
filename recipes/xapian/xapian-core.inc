DESCRPITION = "Open Source Search Engine Library"
HOMEPAGE = "http://xapian.org"
SECTION = "devel/libs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "zlib"

SRC_URI = "http://www.oligarchy.co.uk/xapian/${PV}/xapian-core-${PV}.tar.gz"

BBCLASSEXTEND = "native"

inherit autotools pkgconfig

