DESCRIPTION = "libarena is a custom memory allocator interface and implementation. \
Three allocators are provided: flat "LIFO" arena allocator, object pool allocator and a malloc(3) wrapper."
HOMEPAGE = "http://www.25thandclement.com/~william/projects/libarena.html"
SECTION = "libs"
LICENSE = "${PN}"

SRC_URI = "http://www.25thandclement.com/~william/projects/releases/libarena-${PV}.tgz"

do_stage() {
	oe_libinstall -C src -a libarena ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/arena
	install src/*.h ${STAGING_INCDIR}/arena
}


SRC_URI[md5sum] = "dc51d2466493d16a81af10ae0390b292"
SRC_URI[sha256sum] = "560a17bc5d9e8ef71579391703c2a138d365e68396a5d8b21b1d9e1b232e16d0"
