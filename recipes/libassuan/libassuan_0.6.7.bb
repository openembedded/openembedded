LICENSE = "GPL"
PR = "r1"

SRC_URI = "ftp://ftp.gnupg.org/gcrypt/alpha/libassuan/libassuan-${PV}.tar.gz"

inherit autotools binconfig

do_stage() {
	autotools_stage_includes

	install -d ${STAGING_LIBDIR}
	oe_libinstall -C src -a libassuan ${STAGING_LIBDIR}

	install -d ${STAGING_DATADIR}/aclocal
	install -m 0644 src/libassuan.m4 ${STAGING_DATADIR}/aclocal/
}


SRC_URI[md5sum] = "db4e6939fafbaae80cab11a67f28771d"
SRC_URI[sha256sum] = "c72dc7b2a3bb2945d1fb693b401ddff44f3eefbe248f2e6d29c86487b69c1dd4"
