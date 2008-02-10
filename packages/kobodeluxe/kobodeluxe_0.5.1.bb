DESCRIPTION = "Fast-paced 2D top-down shooter where you have to destroy space station"
SECTION = "games"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "David Olofson <david@olofson.net>"
HOMEPAGE = "http://olofson.net/kobodl"

DEPENDS = "libsdl-image virtual/libsdl"

RDEPENDS_${PN} = "${PN}-data"

SRC_URI = "http://olofson.net/kobodl/download/KoboDeluxe-${PV}.tar.bz2 \
					 file://debian-kobo.patch;patch=1 \
          "

S = "${WORKDIR}/KoboDeluxe-${PV}"

inherit autotools

EXTRA_OECONF = "--disable-sdltest"

PACKAGES += "${PN}-data"

FILES_${PN}-data = "${datadir}"

PACKAGE_ARCH_${PN}-data = "all"
