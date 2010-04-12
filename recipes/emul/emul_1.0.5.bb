DESCRIPTION = "EarthMate Userland Library"
SECTION = "libs/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "virtual/libusb0 ncurses"
PR = "r1"

SRC_URI = "http://download.berlios.de/emul/emul-${PV}.tar.gz"

CFLAGS += "-I${STAGING_INCDIR}"

do_compile() {
	${CC} -c ${CFLAGS} -D_REENTRANT -fPIC -o emul.o src/emul.c
	${CC} -c ${CFLAGS} -D_REENTRANT -fPIC -o buf.o src/buf.c
	${CC} ${LDFLAGS} -shared -fPIC -Wl,-soname,libemul.so.1 -o libemul.so -lusb -lpthread emul.o buf.o

	${CC} -c ${CFLAGS} -Isrc -o sirfmon.o src/sirfmon.c
	${CC} ${LDFLAGS} -L. -lemul -lncurses -lm sirfmon.o -o sirfmon
}

do_install() {
	install -d ${D}${libdir}
	oe_libinstall -so libemul ${D}${libdir}

	install -d ${D}${bindir}
	install -m 0755 sirfmon ${D}${bindir}
}

PACKAGES =+ "sirfmon"
SECTION_sirfmon = "network"
FILES_sirfmon = "${bindir}"
FILES_${PN} = "${libdir}"

SRC_URI[md5sum] = "f713b4d3c6a733b429de2673e4427483"
SRC_URI[sha256sum] = "b91c7fb6420f6787d34b88b1e0d2e705e1006b5bce17235356f84a3c14329612"
