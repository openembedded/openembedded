DESCRIPTION = "The Lemon Parser Generator"
HOMEPAGE = "http://www.hwaci.com/sw/lemon/"
LICENSE = "PD"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PRIORITY = "optional"
SECTION = "devel"

SRC_URI = "http://www.sqlite.org/sqlite-${PV}.tar.gz \
           file://lemon.1"
S = "${WORKDIR}/sqlite-${PV}/tool"

do_compile() {
	${CC} ${CFLAGS} lemon.c -c -o lemon.o
	${CCLD} ${LDFLAGS} lemon.o -o lemon
}
