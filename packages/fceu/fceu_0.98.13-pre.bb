DESCRIPTION = "FCEU Ultra NES Emulator"

SECTION = "games"
LICENSE = "GPL"
HOMEPAGE = "http://fceultra.sourceforge.net"
DEPENDS = "virtual/libsdl"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/fceultra/fceu-${PV}.src.tar.bz2 \
	   file://fceu.patch;pnum=0;patch=1 \
	  "

S = "${WORKDIR}/fceu"

inherit autotools pkgconfig

do_configure() {
    oe_runconf
}

do_stage() {
	autotools_stage_all
}

do_install() {
        oe_runmake 'DESTDIR=${D}' install
}
