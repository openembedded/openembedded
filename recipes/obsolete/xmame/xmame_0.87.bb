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


SRC_URI[md5sum] = "817f825ea92baf5f5e98ecb13193b844"
SRC_URI[sha256sum] = "5bd358381d75f17802a0c8dfc62dcdaf9e782ecad23c0fca3e5c5b6445ff7ba1"
