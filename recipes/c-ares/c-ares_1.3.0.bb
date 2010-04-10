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


SRC_URI[md5sum] = "badb4563a02d4188b478df31fa1b657d"
SRC_URI[sha256sum] = "5c4594f71eab62e24d12c67ae6a6aead306c537cf71e946c4e9fbebbe9786243"
