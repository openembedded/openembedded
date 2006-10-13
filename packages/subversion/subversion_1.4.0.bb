DESCRIPTION = "The Subversion (svn) client"
SECTION = "console/network"
DEPENDS = "apr-util-0.9.12 neon"
LICENSE = "Apache/BSD"
HOMEPAGE = "http://subversion.tigris.org"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://subversion.tigris.org/downloads/${P}.tar.bz2 \
           file://disable-revision-install.patch;patch=1"

EXTRA_OECONF = "--with-neon=${STAGING_DIR}/${BUILD_SYS} \
                --without-berkeley-db --without-apxs --without-apache \ 
                --without-swig --with-apr=${STAGING_BINDIR} \
                --with-apr-util=${STAGING_BINDIR}"

inherit autotools

do_configure() {
	oe_runconf
}
