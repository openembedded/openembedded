DESCRIPTION = "Tools for managing memory technology devices."
SECTION = "base"
DEPENDS = "zlib"
HOMEPAGE = "http://www.linux-mtd.infradead.org/"
LICENSE = "GPLv2"
PR = "r0"

SRC_URI = "ftp://ftp.infradead.org/pub/mtd-utils/mtd-utils-1.0.0.tar.gz"

CFLAGS_prepend = "-I${WORKDIR}/mtd-utils-${PV}/include "

do_install() {
	oe_runmake install DESTDIR=${D}
}
