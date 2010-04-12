DESCRIPTION = "TiMidity++ -- MIDI-to-WAVE converter and player"
HOMEPAGE = "http://timidity.sourceforge.net"
SECTION = "libs/multimedia"
DEPENDS = "libao libogg libvorbis"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/timidity/TiMidity++-${PV}.tar.bz2"
S = "${WORKDIR}/TiMidity++-${PV}"

inherit autotools

do_configure() {
	gnu-configize
	oe_runconf
}

# FIXME patch Makefile to create calcnewt as host tool
do_compile_prepend() {
	${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS} -lm -o timidity/calcnewt timidity/calcnewt.c
}

	

SRC_URI[md5sum] = "a82ceeb2245e22f4de2b41da21eaee32"
SRC_URI[sha256sum] = "0a8524b789b57eaf944c3d9bce32c21a4e893016b22a02a24cd0a4c6afee7260"
