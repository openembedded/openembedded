DESCRIPTION="Classic game where you control a steel ball by tilting a wooden labyrinth"
HOMEPAGE="http://mokomaze.projects.openmoko.org/"
SECTION="x11/games"
PRIORITY="optional"
LICENSE="GPLv3"
DEPENDS="libsdl-ttf libsdl-image ode"
RDEPENDS="ttf-liberation-mono libpng"

PR="r0"
SRC_URI="http://mokomaze.projects.openmoko.org/files/${PN}-${PV}+git8.tar.gz \
         file://avoid_dim_suspend.patch;patch=1"

S=${WORKDIR}/${PN}-${PV}+git8

inherit autotools

EXTRA_OECONF="FONTDIR=${datadir}/fonts/truetype"

# needed for ode
LDFLAGS += "-lstdc++"

