DESCRIPTION = "Numpty Physics is a drawing puzzle game in the spirit (and style?) \
of Crayon Physics using the same excellent Box2D engine."
DEPENDS = "virtual/libsdl libsdl-image"
LICENSE = "GPL"
HOMEPAGE = "http://numptyphysics.garage.maemo.org/"
SECTION = "x11/games"
PV = "0.2+svnr${SRCREV}"

SRC_URI = "\
  svn://garage.maemo.org/svn/${PN};module=trunk;proto=https \
  http://wwwpub.zih.tu-dresden.de/~mkluge/numptyphysics_setup.tgz \
"
S = "${WORKDIR}/trunk"

EXTRA_S = "${WORKDIR}/local/packages/numptyphysics"

# what an ugly buildsystem... handcrafted Makefiles... back to the stoneage
export CCOPTS = "${CFLAGS} -I Box2D/Include"
export LDOPTS = "${LDFLAGS} -lSDL -lSDL_image"

do_configure() {
	for i in Config.h Makefile Game.cpp; do
		install -m 0644 ${EXTRA_S}/$i ${S}
	done
}

do_install() {
        install -d ${D}${datadir}/numptyphysics
        install -d ${D}${bindir}
        install -d ${D}${datadir}/pixmaps
        install -d ${D}${datadir}/applications
        install -m 0755 ${S}/arm/Game ${D}${bindir}/numptyphysics
        install -m 0644 ${EXTRA_S}/star.png ${D}${datadir}/pixmaps
        install -m 0644 ${EXTRA_S}/numptyphysics.desktop ${D}/${datadir}/applications
        cp -a ${EXTRA_S}/data/* ${D}/${datadir}/numptyphysics/
}

FILES_${PN} += "${datadir}"
