DESCRIPTION = "Simple program to read/write from/to any location in memory."
SRC_URI = "http://www.lartmaker.nl/lartware/port/devmem2.c"
LICENSE = "GPLv2"
PR = "r3"

S = "${WORKDIR}"

do_compile() {
	${CC} -o devmem2 devmem2.c ${CFLAGS} ${LDFLAGS}
}

do_install() {
	install -d ${D}${bindir}
	install devmem2 ${D}${bindir}
}
