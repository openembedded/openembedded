DESCRIPTION = "Open source clone of the Microprose game 'Transport Tycoon Deluxe' - SDL edition."
HOMEPAGE = "http://openttd.sf.net"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/openttd/openttd-${PV}-source.tar.gz"

APPIMAGE = "media/openttd.48.png"

EXTRA_OEMAKE = "WITH_ZLIB=1 \
		WITH_PNG=1 \
		WITH_SDL=1 \
		UNIX=1 \
		WITH_NETWORK=1 \
		VERBOSE=1 \
		INSTALL=1 \
		PREFIX=usr \
		BINARY_DIR=bin \
		DATA_DIR=share/games/openttd \
		PERSONAL_DIR=.openttd \
		USE_HOMEDIR=1 \
		CC_HOST=gcc \
		CC_TARGET=${TARGET_SYS}-gcc"

inherit sdl

do_install() {
    oe_runmake install DESTDIR="${D}"
    install -d ${D}${datadir}/games/openttd/scenario/
    install -m 0644 ${S}/scenario/*.scn ${D}${datadir}/games/openttd/scenario/
}

FILES_${PN} += "${datadir}/*"
