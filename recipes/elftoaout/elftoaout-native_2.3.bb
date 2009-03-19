SECTION = "console/utils"
LICENSE = "GPL"
SRC_URI = "http://www.uk.debian.org/debian/pool/main/s/sparc-utils/sparc-utils_1.9.orig.tar.gz"

inherit native

S = "${WORKDIR}/sparc-utils-1.9.orig/elftoaout-${PV}"

do_stage() {
	install elftoaout ${STAGING_BINDIR}
}
