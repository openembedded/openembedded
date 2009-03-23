DESCRIPTION = "c-ares is a C library that resolves names asynchronously."
HOMEPAGE = "http://daniel.haxx.se/projects/c-ares/"
SECTION = "libs"
SRC_URI = "http://daniel.haxx.se/projects/c-ares/c-ares-${PV}.tar.gz"
LICENSE = "MIT"
S = "${WORKDIR}/c-ares-${PV}"

inherit autotools

do_stage() {
        oe_libinstall -C .libs -a libcares ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/ares
	install -m 0644 ares*.h ${STAGING_INCDIR}/ares/
}

