# cppunit OE build file
# Copyright (C) 2005, Koninklijke Philips Electronics NV.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "A cross-platform, open-source make system"
HOMEPAGE = "http://www.cmake.org/"
LICENSE = "Berkely-style license"
SECTION = "console/utils"
MAINTAINER = "Eddy Pronk <epronk@muftor.com>"

SRC_URI = "http://www.cmake.org/files/v2.2/cmake-2.2.1.tar.gz"

inherit autotools

S = "${WORKDIR}/cmake-2.2.1"

inherit native

do_configure () {
	./configure --prefix=${base_prefix} || die "./bootstrap failed"
}
