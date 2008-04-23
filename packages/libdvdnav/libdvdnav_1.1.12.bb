# libdvdnav .bb build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

HOMEPAGE="http://xinehq.de/"
DESCRIPTION="DVD navigation multimeda library"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
LICENSE = "GPL"

S = "${WORKDIR}/libdvdnav-0.1.10"

SRC_URI="${SOURCEFORGE_MIRROR}/dvd/libdvdnav-0.1.10.tar.gz \
	file://dvdnav-xine-lib-1.1.12.patch;patch=1;pnum=1 \
	file://dvdnav-fix-read-dvdlabel.patch;patch=1;pnum=1"

inherit autotools

do_stage() {
	autotools_stage_all
}
