# cppunit OE build file
# Copyright (C) 2005, Koninklijke Philips Electronics NV.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "Unit Testing Library for C++"
HOMEPAGE = "http://cppunit.sourceforge.net/"
LICENSE = "LGPL"
SECTION = "devel"

SRC_URI = "${SOURCEFORGE_MIRROR}/cppunit/cppunit-${PV}.tar.gz"

inherit autotools binconfig

CXXFLAGS_powerpc += "-lstdc++"

do_stage () {
	autotools_stage_includes
	cd ./src/cppunit/.libs/
	oe_libinstall -a -so libcppunit ${STAGING_LIBDIR}
}

SRC_URI[md5sum] = "0bc06cd219410f7d4f6bbfc9bdd7c824"
SRC_URI[sha256sum] = "71b626958e3d8927d236f462b2becd192a113d1d6d38b8d567bdc181b5069ccf"
