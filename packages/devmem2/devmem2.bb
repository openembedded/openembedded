SRC_URI = "http://www.lart.tudelft.nl/lartware/port/devmem2.c"
LICENSE = "GPL"

S = "${WORKDIR}"

do_compile() {
	${CC} -o devmem2 devmem2.c ${CFLAGS} ${LDFLAGS}
}

do_install() {
	install -d ${D}${bindir}
	install devmem2 ${D}${bindir}
}


