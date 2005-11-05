DESCRIPTION = "Super Nintendo Emulator based on SDL, QtE Palmtop Environments Edition"
SECTION = "opie/games"
PRIORITY = "optional"
DEPENDS = "libsdl-qpe"
PR = "r1"
LICENSE = "snes9x"
SRC_URI = "http://www.vanille.de/mirror/snes9x-sdl-${PV}.tar.bz2 \
	   file://compile.patch;patch=1"
S = "${WORKDIR}/snes9x-sdl-${PV}"

FILES_${PN} = "${palmtopdir}/bin/snes9x"

do_compile() {
	oe_runmake CC="${CC}" CCC="${CXX}" \
	           INCLUDES="-I${STAGING_INCDIR} `sdl-config --cflags`" \
	           LDLIBS="`sdl-config --libs` -Wl,-rpath-link,${STAGING_LIBDIR}"
}

do_install() {
	install -d ${D}${palmtopdir}/bin/
	install -m 0755 snes9x ${D}${palmtopdir}/bin/snes9x
}

