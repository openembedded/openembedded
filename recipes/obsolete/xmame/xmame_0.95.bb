DESCRIPTION = "Multiple Arcade Machine Emulator based on SDL"
LICENSE = "xmame"
SECTION = "games"
PRIORITY = "optional"
DEPENDS = "expat virtual/libsdl libsdl-mixer"

SRC_URI = "http://x.mame.net/download/historic/${P}.tar.bz2"

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


SRC_URI[md5sum] = "e2571ce90bdf1517eea4d8085170fe6c"
SRC_URI[sha256sum] = "c3044870d1778b4f6d64463f0aeda2995aade1e0bea0feb6935d18bf44fcf6cb"
