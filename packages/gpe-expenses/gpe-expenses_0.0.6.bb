DESCRIPTION = "Simple expense record keeper for GPE. Equivalent for Expenses on the Palm."
AUTHOR = "Neil Williams"
HOMEPAGE = "http://gpe-expenses.sf.net"
LICENSE = "GPL"
DEPENDS = "qof libgpewidget popt-native libgpepimc"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz \
	  "

inherit autotools pkgconfig


