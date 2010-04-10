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

SRC_URI[md5sum] = "dca09e2949616471669320e3429a49ef"
SRC_URI[sha256sum] = "62c8c36df69c48bed9e8a1406faa5df5d057876b34fc110492c87260a70692c6"
