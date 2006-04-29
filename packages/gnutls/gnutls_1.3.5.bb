DESCRIPTION = "GNU Transport Layer Security Library"
DEPENDS = "zlib libgcrypt lzo"
MAINTAINER = "Eric Shattow <lucent@gmail.com>"

LICENSE = "LGPL"
PR = "r3"

SRC_URI = "ftp://ftp.gnutls.org/pub/gnutls/devel/gnutls-${PV}.tar.bz2 \
           file://gnutls-openssl.patch;patch=1 \
           file://gnutls-texinfo-euro.patch;patch=1"

inherit autotools
inherit binconfig

PACKAGES =+ "${PN}-openssl ${PN}-extra ${PN}-bin"
FILES_${PN}-openssl = "${libdir}/libgnutls-openssl.so.*"
FILES_${PN}-extra = "${libdir}/libgnutls-extra.so.*"
FILES_${PN} = "${libdir}/libgnutls.so.*"
FILES_${PN}-bin = "${bindir}/gnutls-serv \
		   ${bindir}/gnutls-cli \
		   ${bindir}/srptool \
		   ${bindir}/certtool \
		   ${bindir}/gnutls-srpcrypt \
		   ${bindir}/psktool"

FILES_${PN}-dev += "${bindir}/*-config ${bindir}/gnutls-cli-debug"

EXTRA_OECONF="--with-included-opencdk --with-included-libtasn1"

do_stage() {
	oe_libinstall -C lib/.libs -so -a libgnutls ${STAGING_LIBDIR}
	oe_libinstall -C libextra/.libs -so -a libgnutls-extra ${STAGING_LIBDIR}
	oe_libinstall -C libextra/.libs -so -a libgnutls-openssl ${STAGING_LIBDIR}
	autotools_stage_includes
}

