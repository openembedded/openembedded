DESCRIPTION = "A Doom Clone based on SDL"
SECTION = "games"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl libsdl-mixer libsdl-net"
LICENSE = "GPL"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/prboom/prboom-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--without-x --disable-sdltest"

do_install() {
        install -d ${D}${bindir} \
		   ${D}${datadir}/games/doom

	install -m 0755 src/prboom ${D}${bindir}/prboom
	install -m 0644 data/prboom.wad ${D}${datadir}/games/doom/
}

FILES_${PN} += "${datadir}/games/doom/prboom.wad"

SRC_URI[md5sum] = "ef0abe0aad017514857552434b5c6aaa"
SRC_URI[sha256sum] = "200d3c50b082ae46be8c014bb576b4e2d23b1704508fd528c47e3e2b3b04759e"
