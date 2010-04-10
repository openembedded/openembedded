LICENSE = "GPL"

SRC_URI = "ftp://ftp.gnupg.org/gcrypt/alpha/libassuan/libassuan-${PV}.tar.gz"

inherit autotools binconfig

do_stage() {
	autotools_stage_includes

	install -d ${STAGING_LIBDIR}
	oe_libinstall -C src -a libassuan ${STAGING_LIBDIR}

	install -d ${STAGING_DATADIR}/aclocal
	install -m 0644 src/libassuan.m4 ${STAGING_DATADIR}/aclocal/
}


SRC_URI[md5sum] = "7f8aff75d034159b84faf2358263f444"
SRC_URI[sha256sum] = "e62ac18effcbd578f7fae14c9384795321c9a954d258f6bd9da3a620b37f4106"
