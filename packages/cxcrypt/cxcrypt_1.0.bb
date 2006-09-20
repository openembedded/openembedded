DESCRIPTION = "A simple, xor-based encryption tool"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Martin Dietze <herbert@spamcop.net>"
PV = 1.0
LICENSE = LGPL

SRC_URI = "http://www.fh-wedel.de/pub/fh-wedel/staff/herbert/misc/${PN}-${PV}.tar.gz"
S = "${WORKDIR}/cxcrypt"

CFLAGS_prepend = "-g -Wall -ansi -pedantic "
LDFLAGS_prepend = "-L. -lcxio "

do_compile() {
	oe_runmake 
}

do_install() {
	install -d -m 755 ${D}/usr/bin
	install -d -m 755 ${D}/usr/lib
	install -d -m 755 ${D}/usr/include
	install -m 755 cxcrypt ${D}/usr/bin
	install -m 755 libcxio.a ${D}/usr/lib
	install -m 755 cxio.h ${D}/usr/include
}

do_stage() {
	install -d -m 755 ${STAGING_INCDIR}
	install -d -m 755 ${STAGING_LIBDIR}
	install -m 644 cxio.h ${STAGING_INCDIR}
	install -m 644 libcxio.a ${STAGING_LIBDIR}
}

FILES_${PN} = "/usr/bin/${PN}"
FILES_${PN}-dev = "/usr/lib/libcxio.a /usr/include"

