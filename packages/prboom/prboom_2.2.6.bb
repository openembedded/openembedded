DESCRIPTION = "A Doom Clone based on SDL"
SECTION = "games"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl libsdl-mixer libsdl-net"
LICENSE = "GPL"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/prboom/prboom-${PV}.tar.gz \
           file://m4.patch;patch=1"

inherit autotools 

EXTRA_OECONF = " --without-x --disable-sdltest --with-sdl-exec-prefix=${STAGING_DIR}/${BUILD_SYS} "

do_configure() {
	PATH=${STAGING_BINDIR}:$PATH
	gnu-configize
	oe_runconf
}

do_install() {
        install -d ${D}${bindir} \
		   ${D}${datadir}/games/doom
		   
	install -m 0755 src/prboom ${D}${bindir}/prboom
	install -m 0644 data/prboom.wad ${D}${datadir}/games/doom/
}

FILES_${PN} += "${datadir}/games/doom/prboom.wad"
