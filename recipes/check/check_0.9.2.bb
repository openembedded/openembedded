DESCRIPTION = "a unit test framework for C"
LICENSE = "LGPL"
PRIORITY = "optional"
SECTION = "devel"

PR ="r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/check/check-${PV}.tar.gz"
S = "${WORKDIR}/check-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF += "--enable-plain-docdir"

do_stage() {

	install -m 0644 ${S}/src/check.h ${STAGING_INCDIR}/check.h
	oe_libinstall -a -C src libcheck ${STAGING_LIBDIR}
}


SRC_URI[md5sum] = "9a4d5665b8be07513f5ac4e6eec537e6"
SRC_URI[sha256sum] = "fbd7a0595eba5cf0cb168d9893e883f5cc7a68a7d6fec23cb3688508b247fa22"
