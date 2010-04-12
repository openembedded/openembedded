DESCRIPTION = "Simple expense record keeper for GPE. Equivalent for Expenses on the Palm."
AUTHOR = "Neil Williams"
HOMEPAGE = "http://gpe-expenses.sf.net"
LICENSE = "GPL"
DEPENDS = "qof libgpewidget popt-native libgpepimc"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz \
	  "

inherit autotools pkgconfig



SRC_URI[md5sum] = "ee998780d384e68cdd15748392f59980"
SRC_URI[sha256sum] = "9ce4624ca3ca7e641fac7513dcef6614bce611c338466c742a0e19346cf94f82"
