# libdvdnav .bb build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

HOMEPAGE="http://puzzle.dl.sourceforge.net/sourceforge/libmms/"
DESCRIPTION="libmms"
MAINTAINER = "Raymond Danks <info-linux@geode.amd.com>"
LICENSE = "GPL"

SRC_URI="${SOURCEFORGE_MIRROR}/libmms/libmms-${PV}.tar.gz"

inherit autotools pkgconfig


do_stage() {
	autotools_stage_all
}
