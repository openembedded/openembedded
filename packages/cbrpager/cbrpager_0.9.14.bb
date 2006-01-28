HOMEPAGE = "http://www.jcoppens.com/soft/cbrpager/index.en.php"
DESCRIPTION = "A no-nonsense, simple to use, small viewer for cbr and cbz (comic book archive) files."
LICENSE = "GPL"
PR = "r1"

DEPENDS = "gtk+ libgnomeui"
RDEPENDS = "unzip" 

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools








