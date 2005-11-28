# libdbi OE build file
# Copyright (C) 2005, Koninklijke Philips Electronics NV.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "Database Independent Abstraction Layer for C"
HOMEPAGE = "http://libdbi.sourceforge.net/"
LICENSE = "LGPL"
SECTION = "libs"
MAINTAINER = "Eddy Pronk <epronk@muftor.com>"

SRC_URI = "${SOURCEFORGE_MIRROR}/libdbi/libdbi-${PV}.tar.gz"

inherit autotools

do_stage () {
	autotools_stage_includes
	cd ./src/.libs/
	oe_libinstall -so libdbi ${STAGING_LIBDIR}
}

do_configure () {
	autotools_do_configure
}