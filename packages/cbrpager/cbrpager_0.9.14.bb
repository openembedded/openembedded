HOMEPAGE = "http://www.jcoppens.com/soft/cbrpager/index.en.php"
DESCRIPTION = "A no-nonsense, simple to use, small viewer for cbr and cbz (comic book archive) files."
SECTION = "x11/applications"
LICENSE = "GPL"
PR = "r2"

DEPENDS = "gtk+ libgnomeui"
RDEPENDS = "unzip"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools








