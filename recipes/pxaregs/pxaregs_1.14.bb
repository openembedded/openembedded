DESCRIPTION = "Tool to display and modify PXA registers at runtime"
LICENSE = "GPLv2"
AUTHOR = "Holger Schurig <hs4233@mail.mn-solutions.de>"
HOMEPAGE = "http://www.mn-logistik.de/unsupported/pxa250/"

SRC_URI = "http://www.mn-logistik.de/unsupported/pxa250/pxaregs.c \
           file://i2c.patch;pnum=1;patch=1 \
           file://munmap.patch;pnum=1;patch=1 \
           file://serial.patch;pnum=1;patch=1 \
           file://usb.patch;pnum=1;patch=1 "

S = "${WORKDIR}"

do_compile() {
    ${CC} pxaregs.c -o pxaregs ${CFLAGS}
}

do_install() {
	install -d ${D}${sbindir}/
	install -m 0755 pxaregs ${D}${sbindir}/
}
