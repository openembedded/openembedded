DESCRIPTION = "Super Nintendo Emulator based on SDL"
SECTION = "games"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl zlib"
LICENSE = "snes9x"
PR = "r3"

SRC_URI = "http://www.vanille.de/mirror/snes9x-sdl-${PV}.tar.bz2 \
	   file://compile.patch;patch=1 \
	   file://gcc-4.1.patch;patch=1"
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

SRC_URI[md5sum] = "a7836a9b6eaae433079c1c9d19f2635a"
SRC_URI[sha256sum] = "489bb2f9fb69922e9befc27ae1b8d19d31c83c586f55b7ecc503cb4f5e767da4"
