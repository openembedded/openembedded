HOMEPAGE = "http://www.jcoppens.com/soft/cbrpager/index.en.php"
DESCRIPTION = "A no-nonsense, simple to use, small viewer for cbr and cbz (comic book archive) files."
SECTION = "x11/applications"
LICENSE = "GPL"
DEPENDS = "gtk+ libgnomeui"
RDEPENDS_${PN} = "unzip"

INC_PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools








