# cppunit OE build file
# Copyright (C) 2005, Koninklijke Philips Electronics NV.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "Unit Testing Library for C++"
HOMEPAGE = "http://cppunit.sourceforge.net/"
LICENSE = "LGPL"
SECTION = "devel"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/cppunit/cppunit-${PV}.tar.gz"

inherit autotools_stage binconfig

CXXFLAGS_powerpc += "-lstdc++"

