DESCRIPTION = "Super Nintendo Emulator based on SDL"
SECTION = "games"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl zlib"
LICENSE = "snes9x"
PR = "r2"

SRC_URI = "http://www.vanille.de/mirror/snes9x-sdl-${PV}.tar.bz2 \
	   file://compile.patch;patch=1"
S = "${WORKDIR}/snes9x-sdl-${PV}"

do_compile() {
	oe_runmake CC="${CC}" CCC="${CXX} -fno-rtti -fno-exceptions" \
	           INCLUDES="-I${STAGING_INCDIR} `sdl-config --cflags`" \
	           LDLIBS="`sdl-config --libs`"
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 snes9x ${D}${bindir}/snes9x
}

FILES_${PN} = "${bindir}/snes9x"
