DESCRIPTION = "The Subversion (svn) client"
SECTION = "console/network"
DEPENDS = "apr-util neon"
RDEPENDS = "neon"
LICENSE = "Apache BSD"
HOMEPAGE = "http://subversion.tigris.org"

PR = "r1"

SRC_URI = "http://subversion.tigris.org/downloads/${P}.tar.bz2 \
           file://disable-revision-install.patch;patch=1 \
	   file://neon-detection.patch;patch=1"

EXTRA_OECONF = "--with-neon=${STAGING_EXECPREFIXDIR} \
                --without-berkeley-db --without-apxs --without-apache \
                --without-swig --with-apr=${STAGING_BINDIR_CROSS} \
                --with-apr-util=${STAGING_BINDIR_CROSS}"


inherit autotools

export LDFLAGS += " -L${STAGING_LIBDIR} "

do_configure() {
	gnu-configize
	libtoolize --force
	aclocal -I build/ -I build/ac-macros/ && autoconf
	oe_runconf
}

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "de0e792c9804c7bce397d267af5eb30d"
SRC_URI[sha256sum] = "8260a2d3a67c5cebc100e7662f81679582c0f05a2a28260e235bdf051e72aee3"
