SECTION = "devel"
# cramfs-native OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="Disk based hashes is a method to create multidimensional binary trees on disk."
HOMEPAGE="http://dbh.sourceforge.net"
LICENSE="QPL"
SRC_URI="${SOURCEFORGE_MIRROR}/dbh/${PN}_${PV}.tar.bz2 \
	file://${FILESDIR}/configure.patch;patch=1"

S=${WORKDIR}/${PN}_${PV}

inherit autotools pkgconfig

do_stage() {
	install -m 644 src/dbh_config.h ${STAGING_INCDIR}
	install -m 644 src/dbh_functions.h ${STAGING_INCDIR}
	install -m 644 src/dbh.h ${STAGING_INCDIR}

	oe_soinstall src/.libs/libdbh-1.0.so.1.0.0 ${STAGING_LIBDIR}
	ln -s ${STAGING_LIBDIR}/libdbh-1.0.so.1.0.0 ${STAGING_LIBDIR}/libdbh.so
}
