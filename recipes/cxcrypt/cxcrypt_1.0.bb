DESCRIPTION = "A simple, xor-based encryption tool"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "LGPL"

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


SRC_URI[md5sum] = "8b90c19943f1b893cd53072de34f2ca6"
SRC_URI[sha256sum] = "100ec0afc6a5733f2b0c936058d8055d7965078c95ac187a573bf0a5a63cb268"
