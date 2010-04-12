DESCRIPTION = "A Doom Clone based on SDL"
SECTION = "games"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl libsdl-mixer libsdl-net"
LICENSE = "GPL"

PR = "r1"
RRECOMMENDS = "freedoom"

SRC_URI = "${SOURCEFORGE_MIRROR}/prboom/prboom-${PV}.tar.gz \
	   "

inherit autotools

EXTRA_OECONF = " --disable-gl --disable-cpu-opt --without-x --disable-sdltest"

do_install() {
        install -d ${D}${bindir} \
		   ${D}${datadir}/games/doom

	install -m 0755 src/prboom ${D}${bindir}/prboom
	install -m 0644 data/prboom.wad ${D}${datadir}/games/doom/
}

FILES_${PN} += "${datadir}/games/doom/prboom.wad"

SRC_URI[md5sum] = "9942f521764d7f89df2218a456da4f02"
SRC_URI[sha256sum] = "de22dbaacd25a0f0b16c507aa2326a90b7f5dcfcf862c3dc7076996c6187cd2f"
