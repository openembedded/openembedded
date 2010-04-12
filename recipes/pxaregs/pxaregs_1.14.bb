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
    ${CC} pxaregs.c -o pxaregs ${CFLAGS} ${LDFLAGS}
}

do_install() {
	install -d ${D}${sbindir}/
	install -m 0755 pxaregs ${D}${sbindir}/
}

SRC_URI[md5sum] = "a43baa88842cd5926dbffb6fb87624f6"
SRC_URI[sha256sum] = "f339b91cd8ab348052c36b36d20033e4bffc3666bc836ff72d5704f025e1c057"
