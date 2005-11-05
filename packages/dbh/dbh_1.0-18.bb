# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)
DESCRIPTION ="Disk based hashes is a method to create multidimensional binary trees on disk."
HOMEPAGE = "http://dbh.sourceforge.net"
LICENSE = "GPL"
SECTION = "libs"
SRC_URI = "${SOURCEFORGE_MIRROR}/dbh/dbh_${PV}.tar.bz2 \
	   file://${FILESDIR}/configure.patch;patch=1"

S="${WORKDIR}/dbh_${PV}"

inherit autotools pkgconfig

do_stage() {
	install -m 644 src/dbh_config.h ${STAGING_INCDIR}
	install -m 644 src/dbh_functions.h ${STAGING_INCDIR}
	install -m 644 src/dbh.h ${STAGING_INCDIR}

	oe_libinstall -C src/.libs libdbh-1.0 ${STAGING_LIBDIR}
}
