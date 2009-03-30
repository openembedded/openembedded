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
