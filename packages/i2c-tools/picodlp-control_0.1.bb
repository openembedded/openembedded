DESCRIPTION = "Small application to control the pico DLP over I2C"
LICENSE = "GPLv3"

SRC_URI = "file://${PN}.c file://i2c-dev.h"

do_configure() {
	cp ${WORKDIR}/*.[ch] ${S}
}

do_compile() {
	${CC} -o ${PN} ${PN}.c ${CFGLAGS} ${LDFLAGS}
}

do_install() {
	install -d ${D}/${bindir}
	install -m -755 ${S}/${PN} {D}/${bindir}
}

