DESCRIPTION = "c-ares is a C library that resolves names asynchronously."
HOMEPAGE = "http://daniel.haxx.se/projects/c-ares/"
SECTION = "libs"
SRC_URI = "http://daniel.haxx.se/projects/c-ares/c-ares-${PV}.tar.gz"
LICENSE = "MIT"
S = "${WORKDIR}/c-ares-${PV}"
PR = "r1"

inherit autotools

EXTRA_OECONF = "--enable-shared"

do_stage() {
        oe_libinstall -C .libs -a -so libcares ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/ares
	install -m 0644 ares*.h ${STAGING_INCDIR}/ares/
}


SRC_URI[md5sum] = "ec202543a8cb86647f52e1ed4b5c0b37"
SRC_URI[sha256sum] = "3037156096ea9fee7c40c771207ab8f21b862cb38b6ca62cc0ac464223f9b643"
