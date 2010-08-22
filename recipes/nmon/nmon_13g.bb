DESCRIPTION = "nmon performance monitor"
HOMEPAGE = "http://nmon.sf.net"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "ncurses"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/nmon/lmon13g.c"

SRC_URI[md5sum] = "b1b8e6c0123ad232394991f2d4f40494"
SRC_URI[sha256sum] = "456ab2a342b31d1a352d0d940af5962fa65a12ae8757ff73e6e73210832ae8b5"

CFLAGS += "-D JFS -D GETUSER -Wall -D LARGEMEM"
LDFLAGS += "-lncurses"

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} ${WORKDIR}/lmon13g.c -o nmon
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 nmon ${D}${bindir}
}
