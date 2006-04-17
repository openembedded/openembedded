DESCRIPTION = "Super Nintendo Emulator based on SDL, QtE Palmtop Environments Edition"
SECTION = "opie/games"
PRIORITY = "optional"
DEPENDS = "libsdl-qpe"
LICENSE = "snes9x"
PR = "r3"

SRC_URI = "http://www.vanille.de/mirror/snes9x-sdl-${PV}.tar.bz2 \
	   file://compile.patch;patch=1"
S = "${WORKDIR}/snes9x-sdl-${PV}"

FILESPATH = "${FILE_DIRNAME}/${PN}-${PV}:${FILE_DIRNAME}/snes9x-sdl-${PV}:${FILE_DIRNAME}/snes9x-sdl:${FILE_DIRNAME}/files:${FILE_DIRNAME}"

inherit qmake-base

do_compile() {
	oe_runmake CC="${CC}" CCC="${CXX}" \
	           INCLUDES="-I${STAGING_INCDIR} `sdl-config --cflags`" \
	           LDLIBS="`sdl-config --libs` -L${OE_QMAKE_LIBDIR_QT} -Wl,-rpath-link,${STAGING_LIBDIR} -lqpe -lqte"
}

do_install() {
	install -d ${D}${palmtopdir}/bin/
	install -m 0755 snes9x ${D}${palmtopdir}/bin/snes9x
}

FILES_${PN} = "${palmtopdir}/bin/snes9x"
