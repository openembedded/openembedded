# cdtool .bb build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

HOMEPAGE="http://hinterhof.net/cdtool/"
DESCRIPTION="cdtool is a free software package to control the audio functions \
of an attached CDROM drive from the command line in a quick and scriptable way."
LICENSE = "GPL"

SRC_URI="http://hinterhof.net/${PN}/dist/${PN}-${PV}.tar.gz \
	file://install-no-owner.patch;patch=1"

inherit autotools

SRC_URI[md5sum] = "7b19b6f68d2c648296378b784d5f7681"
SRC_URI[sha256sum] = "73de81ea2de2eae64b888e1b2739ef643ccea13c79790569f8e6278369976a21"
