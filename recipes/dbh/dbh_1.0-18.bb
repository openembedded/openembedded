# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)
DESCRIPTION ="Disk based hashes is a method to create multidimensional binary trees on disk."
HOMEPAGE = "http://dbh.sourceforge.net"
LICENSE = "GPL"
SECTION = "libs"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/dbh/dbh_${PV}.tar.bz2 \
	   file://configure.patch;patch=1"

S="${WORKDIR}/dbh_${PV}"

inherit autotools pkgconfig

do_stage() {
autotools_stage_all
}
