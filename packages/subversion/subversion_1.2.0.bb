DESCRIPTION = "The Subversion (svn) client"
SECTION = "console/network"
DEPENDS = "apr-util"
MAINTAINER = "Mustafa Yuecel <yuecelm@ee.ethz.ch>"
LICENSE = "GPL"

PR = "r0"

SRC_URI = "http://subversion.tigris.org/downloads/${P}.tar.bz2 \
	   file://disable-revision-install.patch;patch=1"

EXTRA_OECONF = "--without-neon --without-berkeley-db --without-apxs --without-apache --without-swig --with-apr=${STAGING_BINDIR} --with-apr-util=${STAGING_BINDIR}"

inherit autotools

do_configure() {
  oe_runconf
}
