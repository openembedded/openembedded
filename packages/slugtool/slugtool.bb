SECTION = "unknown"
DESCRIPTION = "Slugtool is a small app to disassemble and reassemble \
flash images for the Linksys NSLU2 device."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
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
