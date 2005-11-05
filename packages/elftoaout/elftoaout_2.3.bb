SECTION = "console/utils"
LICENSE = "GPL"
SRC_URI = "http://www.uk.debian.org/debian/pool/main/s/sparc-utils/sparc-utils_1.9.orig.tar.gz"

S = "${WORKDIR}/sparc-utils-1.9.orig/elftoaout-${PV}"

do_install() {
	install -d ${D}${bindir}
	install elftoaout ${D}${bindir}/
}
