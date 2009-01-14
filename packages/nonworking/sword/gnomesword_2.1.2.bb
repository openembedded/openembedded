DESCRIPTION = "GUI frontend for sword"
HOMEPAGE = "http://gnomesword.sf.net"
LICENSE = "GPLv3"
DEPENDS = "gail libgnomeui gtkhtml-3.6 gail sword"


SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools pkgconfig


