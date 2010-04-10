# libcdaudio .bb build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

HOMEPAGE = "http://libcdaudio.sourceforge.net/"
DESCRIPTION = "Portable library for controlling audio CDs"
SECTION = "libs"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz"

inherit autotools

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "15de3830b751818a54a42899bd3ae72c"
SRC_URI[sha256sum] = "5fdaf9af5ac4f75c0215d000b82b128fd054a582f81cc4f039a1e7fe69335ebb"
