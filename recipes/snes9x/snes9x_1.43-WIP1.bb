SECTION = "x11/games"
PR = "r4"
LICENSE = "snes9x"
DEPENDS = "libxxf86dga libxxf86vm"
DEPENDS_append_i686 = " nasm-native"
RDEPENDS_epia = "kernel-module-joydev"

SRC_URI = "http://www.lysator.liu.se/snes9x/1.43-WIP1/snes9x-1.43-WIP1-src.tar.gz \
	file://makefile.patch;patch=1;pnum=2 \
	file://private.patch;patch=1;pnum=0 \
	file://64bit.patch;patch=1 \
        file://configure.patch;patch=1;pnum=0 \
        file://linkage.patch;patch=1;pnum=0"

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

SRC_URI[md5sum] = "caa2ed89fdc643a18310d2a50db1e02c"
SRC_URI[sha256sum] = "bc14905c7a7967de59b70909c021d2439d9ec1c9bae835b70cdb786e59caa81c"
