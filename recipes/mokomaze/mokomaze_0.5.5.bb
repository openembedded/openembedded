DESCRIPTION = "Classic game where you control a steel ball by tilting a wooden labyrinth"
HOMEPAGE = "http://mokomaze.projects.openmoko.org/"
SECTION = "x11/games"
PRIORITY = "optional"
LICENSE = "GPLv3"
DEPENDS = "libsdl-ttf libsdl-image ode"
RDEPENDS_${PN} = "ttf-liberation-mono libpng"
RRECOMMENDS_${PN}_shr = "fsoraw"
PV = "0.5.5+git8"
PR = "r7"

SRC_URI = "http://mokomaze.projects.openmoko.org/files/${PN}-${PV}.tar.gz"
SRC_URI_append_shr = " file://fsoraw.patch"
SRC_URI_append_shr = " file://0001-Fix-accelerometers-with-2.6.34-kernels.patch"
SRC_URI_append_shr = " file://0001-Fix-vibration-on-gta02-with-2.6.34-kernel.patch"
SRC_URI[md5sum] = "f4e1dbd444b4049c361f9c1c3d40d32b"
SRC_URI[sha256sum] = "515d842b79a2c34f5789fa10110bc9d7b15c65a7b1fa623131a1e03599fe7362"

inherit autotools

EXTRA_OECONF = "FONTDIR=${datadir}/fonts/truetype --enable-rgb-swap"

# needed for ode
LDFLAGS += "-lstdc++"
