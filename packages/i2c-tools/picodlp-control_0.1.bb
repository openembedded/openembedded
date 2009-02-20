DESCRIPTION = "Small application to control the pico DLP over I2C"
LICENSE = "GPLv3"
PR = "r3"

SRC_URI = "file://*.c file://*.h file://${PN}"

do_configure() {
	cp ${WORKDIR}/*.[ch] ${WORKDIR}/${PN} ${S}
}

do_compile() {
	${CC} -o bus3-i2c *.c ${CFLAGS} ${LDFLAGS}
}

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/${PN} ${D}/${bindir}
	install -m 0755 ${S}/bus3-i2c ${D}/${bindir}
}

