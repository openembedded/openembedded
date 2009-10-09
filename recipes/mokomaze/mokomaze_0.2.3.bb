DESCRIPTION="Classic game where you control a steel ball by tilting a wooden labyrinth"
HOMEPAGE="http://mokomaze.projects.openmoko.org/"
SECTION="x11/games"
PRIORITY="optional"
LICENSE="GPLv3"
DEPENDS="libsdl-ttf libsdl-image"
RDEPENDS="ttf-liberation-mono"


PR="r4"
SRC_URI="http://projects.openmoko.org/frs/download.php/764/${P}.tar.gz \
         file://adapt_ttf_fontdir.patch;patch=1 \
         file://fix_desktop_file.patch;patch=1 \
         file://avoid_dim_suspend.patch;patch=1"

inherit autotools

# FIXME: This should suffice to specify the fontdir, but it does not work
# Therefore we simply patch the makefile now to use the correct fontdir
#EXTRA_OEMAKE="FONTDIR=${datadir}/fonts/truetype"


