DESCRIPTION = "Numpty Physics is a drawing puzzle game in the spirit (and style?) \
of Crayon Physics using the same excellent Box2D engine."
DEPENDS = "virtual/libsdl libsdl-image libpng"
RDEPENDS += "libpng"
LICENSE = "GPL"
HOMEPAGE = "http://numptyphysics.garage.maemo.org/"
SECTION = "x11/games"
PV = "0.2+svnr${SRCPV}"
PR = "r1"

inherit autotools

SRC_URI = "\
# Maemo garage is sadly only available with https. Can make you trouble while fetching without accepting the certificate.
  svn://garage.maemo.org/svn/${PN};module=trunk;proto=https \
  http://wwwpub.zih.tu-dresden.de/~mkluge/numptyphysics_setup.tgz \
  file://replay_off.patch;patch=1;pnum=0 \
  file://next.png \
  file://keyb.patch;patch=1;pnum=0 \
  file://keyb.png \
  file://faster.patch;patch=1;pnum=0 \
  file://numptyphysics.desktop \
"
S = "${WORKDIR}/trunk"

EXTRA_S = "${WORKDIR}/local/packages/numptyphysics"

do_configure_append() {
  mv ../next.png data
  mv ../keyb.png data
}

do_install_append() {
        install -d ${D}${datadir}/numptyphysics
        install -d ${D}${datadir}/pixmaps
        install -d ${D}${datadir}/applications
        install -m 0644 ${EXTRA_S}/star.png ${D}${datadir}/pixmaps
        install -m 0644 ../numptyphysics.desktop ${D}/${datadir}/applications
        cp -a ${EXTRA_S}/data/* data/keyb.png ${D}/${datadir}/numptyphysics/
}

FILES_${PN} += "${datadir}"
