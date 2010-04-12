SECTION = "unknown"
DESCRIPTION = "Slugtool is a small app to disassemble and reassemble \
flash images for the Linksys NSLU2 device."
PR = "r1"
LICENSE = "GPL"
SRC_URI = "http://www.lantz.com/filemgmt_data/files/slugtool.tar.gz \
	   file://redboot_typo.patch;patch=1"
S = "${WORKDIR}"

do_compile () {
	${CC} ${CFLAGS} ${LDFLAGS} slugtool.c -o slugtool
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 slugtool ${D}${bindir}/
}

SRC_URI[md5sum] = "d83e00e9c691984f36cb421d84873bc7"
SRC_URI[sha256sum] = "0a2080a48f8a52d10d49aa78a66027205920b76c8e901d07fb040759191aad9e"
