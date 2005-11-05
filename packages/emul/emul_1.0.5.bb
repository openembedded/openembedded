DESCRIPTION = "EarthMate Userland Library"
SECTION = "libs/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "libusb ncurses"
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
