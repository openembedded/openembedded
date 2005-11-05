SECTION = "x11/games"
PR = "r3"
LICENSE = "snes9x"
DEPENDS = "libxxf86dga libxxf86vm"
DEPENDS_append_i686 = " nasm-native"
RDEPENDS_epia = "kernel-module-joydev"

SRC_URI = "http://www.lysator.liu.se/snes9x/1.43-WIP1/snes9x-1.43-WIP1-src.tar.gz \
	file://makefile.patch;patch=1;pnum=2 \
	file://private.patch;patch=1;pnum=0"

S = "${WORKDIR}/snes9x-1.43-dev-src/snes9x"

inherit autotools

export OECFLAGS="${CFLAGS}"
export OELDFLAGS="${LDFLAGS}"

do_configure() {
	oe_runconf
}

do_install() {
	install -d ${D}${bindir}
	install snes9x ${D}${bindir}
}
