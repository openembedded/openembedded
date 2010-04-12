DESCRIPTION = "Bluetooth firmware poker for bccm2035 chips (motorola phones and palms)"
LICENSE = "GPLv2"

PR = "r1"

SRC_URI = "http://people.openezx.org/wyrm/bcm2035-tool.tgz \
           file://addr-as-arg.patch;patch=1 \
	   "

S = "${WORKDIR}/${PN}"

do_compile() {
	${CC} bcm2035-tool.c -o bcm2035-tool
}

do_install() {
	install -d ${D}${sbindir}
	install -m 755 bcm2035-tool ${D}${sbindir}
}

SRC_URI[md5sum] = "437a39c6008ea6987af1bbaf2252e7b9"
SRC_URI[sha256sum] = "a2e482900eb45154653a692565d81ddeb4b59cd438628c1b14beb822499afef7"
