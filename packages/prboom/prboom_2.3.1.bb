DESCRIPTION = "A Doom Clone based on SDL"
SECTION = "opie/games"
PRIORITY = "optional"
DEPENDS = "libsdl-qpe libsdl-mixer libsdl-net"
LICENSE = "GPL"

# This version can be started w/ -height 240 but it
# a) doesn't load doom1.wad (crash)
# b) crahes a few seconds after starting w/ doom2.wad
DEFAULT_PREFERENCE = -1

SRC_URI = "${SOURCEFORGE_MIRROR}/prboom/prboom-${PV}.tar.gz \
           file://m4.patch;patch=1 \
           file://prboom.png \
           file://prboom.desktop"

inherit autotools 

EXTRA_OECONF = " --without-x --disable-sdltest --with-sdl-exec-prefix=${STAGING_DIR}/${BUILD_SYS} "

do_configure() {
	PATH=${STAGING_BINDIR}:$PATH
	gnu-configize
	oe_runconf
}

do_install() {
        install -d ${D}${palmtopdir}/bin \
        	   ${D}${palmtopdir}/apps/Games \
        	   ${D}${palmtopdir}/pics \
		   ${D}${datadir}/games/doom
	install -m 0755 src/prboom ${D}${palmtopdir}/bin/prboom
	install -m 0644 data/prboom.wad ${D}${datadir}/games/doom/
	install -m 0644 ${WORKDIR}/prboom.png ${D}${palmtopdir}/pics/prboom.png
	install -m 0644 ${WORKDIR}/prboom.desktop ${D}${palmtopdir}/apps/Games/prboom.desktop
}

FILES_${PN} = "${palmtopdir} ${datadir}/games/doom/prboom.wad"
