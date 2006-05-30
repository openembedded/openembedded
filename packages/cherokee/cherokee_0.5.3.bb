DESCRIPTION = "Cherokee Web Server fast and secure"
DESCRIPTION_cget = "Small downloader based in the Cherokee client library"
LICENSE = "GPL"
DEPENDS = "pcre gnutls"
HOMEPAGE = "http://www.0x50.org/"
PR = "r1"

SRC_URI = "http://www.0x50.org/download/0.5/${PV}/cherokee-${PV}.tar.gz \
	  file://configure.patch;patch=1 \
	  file://Makefile.in.patch;patch=1 \
	  file://Makefile.cget.patch;patch=1 \
	  file://util.patch;patch=1"

inherit autotools pkgconfig binconfig

EXTRA_OECONF = "--enable-tls=gnutls --disable-static --disable-nls"

do_configure() {
	gnu-configize
	oe_runconf
	sed -i 's:-L\$:-L${STAGING_LIBDIR} -L\$:' ${S}/*libtool
}

do_install_prepend () {
	$BUILD_CC -DHAVE_SYS_STAT_H -o cherokee_replace cherokee_replace.c
}

PACKAGES =+ "cget libcherokee-server libcherokee-client libcherokee-base"

FILES_cget = "${bindir}/cget"
FILES_libcherokee-server = "${libdir}/libcherokee-server*"
FILES_libcherokee-client = "${libdir}/libcherokee-client*"
FILES_libcherokee-base = "${libdir}/libcherokee-base*"
