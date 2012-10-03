DESCRIPTION = "The Subversion (svn) client"
SECTION = "console/network"
DEPENDS = "apr-util neon sqlite3"
RDEPENDS_${PN} = "neon"
LICENSE = "Apache BSD"
HOMEPAGE = "http://subversion.tigris.org/"

PR = "r2"

SRC_URI = "http://subversion.tigris.org/downloads/${P}.tar.bz2 \
	   file://disable-revision-install.patch \
	   file://libtool2.patch \
	   file://fix-install-depends.patch \
	   "

EXTRA_OECONF = "--without-berkeley-db --without-apxs --without-apache \
                --without-swig --with-apr=${STAGING_BINDIR_CROSS} \
                --with-apr-util=${STAGING_BINDIR_CROSS} \
		ac_cv_path_RUBY=none"


inherit autotools

export LDFLAGS += " -L${STAGING_LIBDIR} "

acpaths = "-I build/ -I build/ac-macros/"

do_configure_prepend () {
	rm -f ${S}/libtool
	rm -f ${S}/build/libtool.m4
	sed -i -e 's:with_sasl="/usr/local":with_sasl="${STAGING_DIR}":' ${S}/build/ac-macros/sasl.m4
}

SRC_URI[md5sum] = "1a53a0e72bee0bf814f4da83a9b6a636"
SRC_URI[sha256sum] = "64331bda459e984b8d369b449eec89daa2f3cd288186f1d2a9ad8011badd4dad"
