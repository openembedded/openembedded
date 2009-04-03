DESCRIPTION = "GUI frontend for sword"
HOMEPAGE = "http://gnomesword.sf.net"
LICENSE = "GPLv3"
DEPENDS = "libgnomeui gtkhtml-3.6 virtual/gail sword"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools pkgconfig


