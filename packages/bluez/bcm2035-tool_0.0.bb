DESCRIPTION = "Bluetooth firmware poker for bccm2035 chips (motorola phones and palms)"
LICENSE = "GPLv2"

SRC_URI = "http://people.openezx.org/wyrm/bcm2035-tool.tgz"

# Note: everyone will have the same BDADDR for the time being 

S = "${WORKDIR}/${PN}"

do_compile() {
	${CC} bcm2035-tool.c -o bcm2035-tool
}

do_install() {
	install -d ${D}${sbindir}
	install -m 755 bcm2035-tool ${D}${sbindir}
}
