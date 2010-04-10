# libdvdnav .bb build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

HOMEPAGE="http://dvd.sourceforge.net/"
DESCRIPTION="DVD navigation multimeda library"
SECTION = "libs"
LICENSE = "GPL"
PR = "r1"

SRC_URI="${SOURCEFORGE_MIRROR}/dvd/${PN}-${PV}.tar.gz"

inherit autotools

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "c8ddee96ba1182d73447eaf0bb6fde81"
SRC_URI[sha256sum] = "c2c6ee274cbd5759715a786b949df8ac3e848ffc771173c4f006b88c665346d0"
