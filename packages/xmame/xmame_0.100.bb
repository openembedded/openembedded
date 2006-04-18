DESCRIPTION = "Multiple Arcade Machine Emulator based on SDL"
LICENSE = "xmame"
SECTION = "games"
PRIORITY = "optional"
DEPENDS = "expat virtual/libsdl libsdl-mixer"

SRC_URI = "http://x.mame.net/download/historic/xmame-${PV}.tar.bz2 file://tiny.mak"
S = "${WORKDIR}/xmame-${PV}"

inherit flow-lossage

do_compile() {
    test -z "${TINY}" && oe_runmake TARGET="mame" CC="${BUILD_CC}" maketree xmame.obj/cpu/m68000/m68kmake
    oe_runmake TARGET="mame" JOY_SDL=1 SOUND_SDL=1 DISPLAY_METHOD=SDL                                   \
               CC="${CC}" CXX="${CXX}" CFLAGS="-I. -Isrc -Isrc/include -Isrc/unix ${CFLAGS}"          \
               CXXFLAGS="${CXXFLAGS}" LD="${CC}" LDFLAGS="${LDFLAGS}"                                 \
               RANLIB="${RANLIB}" MY_CPU="${TARGET_ARCH}" ARCH="${TARGET_OS}"                         \
               GLLIBS="" STRIP="${STRIP}" AR="${AR}"
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 xmame.SDL ${D}${bindir}
}
