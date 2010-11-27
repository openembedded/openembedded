DESCRIPTION = "Multiple Arcade Machine Emulator based on SDL     "
LICENSE = "xmame"
SECTION = "games"
PRIORITY = "optional"
DEPENDS = "expat virtual/libsdl libsdl-mixer"

SRC_URI = "http://x.mame.net/download/historic/xmame-${PV}.tar.bz2 file://tiny.mak"
S = "${WORKDIR}/xmame-${PV}"

PR = "r2"

inherit flow-lossage siteinfo

ENDIANESS = "${@base_conditional('SITEINFO_ENDIANNESS', 'le', '-DLSB_FIRST', '-DMSB_FIRST', d)}"

do_compile() {
    test -z "${TINY}" && oe_runmake TARGET="mame" CC="${BUILD_CC}" maketree xmame.obj/cpu/m68000/m68kmake
    oe_runmake TARGET="mame" SOUND_ALSA=1 DISPLAY_METHOD=x11 X11_MITSHM=1 X11_XV=1 XINPUT_DEVICES=1      \
               CC="${CC}" CXX="${CXX}" CFLAGS="-I. -Isrc -Isrc/include -Isrc/unix ${CFLAGS} ${ENDIANESS}"  \
               CXXFLAGS="${CXXFLAGS}" LD="${CC}" LDFLAGS="${LDFLAGS}"                                      \
               RANLIB="${RANLIB}" MY_CPU="${TARGET_ARCH}" ARCH="${TARGET_OS}"                              \
               GLLIBS="" STRIP="${STRIP}" AR="${AR}"
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 xmame.x11 ${D}${bindir}
}

SRC_URI[md5sum] = "c289797531d540853c835a2bb9fad8bc"
SRC_URI[sha256sum] = "7cceeadeab80f605ed1fba47feb9fd1736d08626ba3f5374dfbe55659232cdd3"
