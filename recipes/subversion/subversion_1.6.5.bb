DESCRIPTION = "The Subversion (svn) client"
SECTION = "console/network"
DEPENDS = "apr-util neon sqlite3"
RDEPENDS = "neon"
LICENSE = "Apache BSD"
HOMEPAGE = "http://subversion.tigris.org/"

PR = "r0"

SRC_URI = "http://subversion.tigris.org/downloads/${P}.tar.bz2 \
	   file://disable-revision-install.patch;patch=1"

EXTRA_OECONF = "--without-berkeley-db --without-apxs --without-apache \
                --without-swig --with-apr=${STAGING_BINDIR_CROSS} \
                --with-apr-util=${STAGING_BINDIR_CROSS}"


inherit autotools

acpaths = "-I build/ac-macros"

# FIXME: Ugly hack!
do_configure_append() {
	if ! test -f libtool ; then cp -a *-libtool libtool ; fi
}

do_stage() {
	autotools_stage_all
}
