DESCRIPTION = "GnuPG Made Easy (GPGME) is a library designed to make access to GnuPG easier for applications"
HOMEPAGE = "http://www.gnupg.org/gpgme.html"
LICENSE = "GPL"
DEPENDS = "libgpg-error pth libassuan"
RRECOMMENDS_${PN} = "gnupg"

SRC_URI = "ftp://ftp.gnupg.org/gcrypt/gpgme/gpgme-${PV}.tar.gz"

EXTRA_OECONF = "--with-pth=${STAGING_DIR_HOST}${layout_exec_prefix} --without-pth-test --with-gpg=${bindir}/gpg --without-gpgsm"

LEAD_SONAME = "libgpgme.so"

inherit autotools binconfig

do_stage() {
	autotools_stage_includes

	install -d ${STAGING_LIBDIR}
	oe_libinstall -C gpgme -so libgpgme ${STAGING_LIBDIR}
	oe_libinstall -C gpgme -so libgpgme-pth ${STAGING_LIBDIR}
	oe_libinstall -C gpgme -so libgpgme-pthread ${STAGING_LIBDIR}

	install -d ${STAGING_DATADIR}/aclocal
	install -m 0644 gpgme/gpgme.m4 ${STAGING_DATADIR}/aclocal/
}

FILES_${PN} = "${libdir}/libgpgme*.so.*"
FILES_${PN}-dev += "${bindir}/gpgme-config"
