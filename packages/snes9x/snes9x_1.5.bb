SECTION = "x11/games"
PR = "r3"
LICENSE = "snes9x"
DEPENDS = "virtual/libx11 zlib"
#DEPENDS = "libxxf86dga libxxf86vm"
DEPENDS_append_i686 = " nasm-native"
RDEPENDS_epia = "kernel-module-joydev"

SRC_URI = "http://files.ipherswipsite.com/snes9x/snes9x-1.5-src.tar.bz2"
#	file://makefile.patch;patch=1;pnum=2 \
#	file://private.patch;patch=1;pnum=0"

S = "${WORKDIR}/snes9x-1.5-src"

inherit autotools

export OECFLAGS="${CFLAGS}"
export OELDFLAGS="${LDFLAGS}"

EXTRA_OECONF = "--without-extensions"

do_install() {
	install -d ${D}${bindir}
	install snes9x ${D}${bindir}
}
