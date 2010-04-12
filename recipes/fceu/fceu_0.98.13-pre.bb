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

SRC_URI[md5sum] = "1977214a15a341a4fd8bad14eda76866"
SRC_URI[sha256sum] = "a227f2d8a3b79462a895435be26c1622f03c5978d2e3e5456d6284592e88a6c2"
