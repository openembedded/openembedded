DESCRIPTION = "Multiple Arcade Machine Emulator based on SDL"
LICENSE = "xmame"
SECTION = "games"
PRIORITY = "optional"
DEPENDS = "expat virtual/libsdl libsdl-mixer"

SRC_URI = "http://x.mame.net/download/historic/${P}.tar.bz2 \
          file://${FILESDIR}/crosscompile.patch;patch=1"

inherit flow-lossage

EXTRA_OEMAKE=

do_compile() {
    oe_runmake TARGET=mame JOY_SDL=1 SOUND_SDL=1 DISPLAY_METHOD=SDL                                   \
               CC="${CC}" CXX="${CXX}" CFLAGS="-I. -Isrc -Isrc/include -Isrc/unix ${CFLAGS}"          \
               CXXFLAGS="${CXXFLAGS}" LD="${CC}" LDFLAGS="${LDFLAGS}"                                 \
               RANLIB="${RANLIB}" MY_CPU="${TARGET_ARCH}" ARCH="${TARGET_OS}"                         \
               GLLIBS="" STRIP="${STRIP}" AR="${AR}"
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 xmame.SDL ${D}${bindir}
}


SRC_URI[md5sum] = "b16782cd620ef970233eacd65462ad74"
SRC_URI[sha256sum] = "bcb35dd4cb138e06bb016a42316dfcc59f82eeed6357902e1f230b4815e9ad93"
