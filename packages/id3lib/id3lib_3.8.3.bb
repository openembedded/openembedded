DESCRIPTION = "Library for interacting with ID3 tags."
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "jason haslup <openembedded@haslup.com>"
DEPENDS = "zlib"
DESCRIPTION = "Library for interacting with ID3 tags."
LICENSE = "GPL"

inherit autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/id3lib/id3lib-${PV}.tar.gz"
S = "${WORKDIR}/id3lib-${PV}"

do_configure() {
	oe_runconf
}

do_stage() {
	oe_libinstall -a -so -C src libid3 ${STAGING_LIBDIR}
	install -m 0644 include/id3.h ${STAGING_INCDIR}
	install -d ${STAGING_INCDIR}/id3/
	install -m 0644 include/id3/*.h ${STAGING_INCDIR}/id3/
}
