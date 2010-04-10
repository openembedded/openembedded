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

SRC_URI[md5sum] = "a8a15f61fa2626ab98051ab2703378c4"
SRC_URI[sha256sum] = "226c1c470f8cc983327536404f405a1d026cf0a5188c694a1243cc8630014bae"
