DESCRIPTION = "A user-space tool to show and modify the state of GPIOs on the S3c24xx platform"
SECTION = "console/utils"
LICENSE = "GPL"
PV = "1.0+svn${SRCREV}"
PR = "r1"

SRC_URI = "svn://svn.openmoko.org/trunk/src/target;module=gpio;proto=http"
S = "${WORKDIR}/gpio"

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} -static -o ${PN} gpio.c
}

do_install() {
	install -d ${D}${sbindir}
	install -m 0755 ${PN} ${D}${sbindir}
}
