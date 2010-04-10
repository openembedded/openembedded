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


SRC_URI[md5sum] = "23adb3729e09879cd2147b31ea5a986e"
SRC_URI[sha256sum] = "41f2df62e8f267cfd0ea9b9d29398f02ec3e22225f06f705e3fa8055370f94a4"
