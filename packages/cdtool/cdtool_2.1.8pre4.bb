# cdtool .bb build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

HOMEPAGE="http://hinterhof.net/cdtool/"
DESCRIPTION="cdtool is a free software package to control the audio functions \
of an attached CDROM drive from the command line in a quick and scriptable way."
MAINTAINER = "Raymond Danks <info-linux@geode.amd.com>"
LICENSE = "GPL"

SRC_URI="http://hinterhof.net/${PN}/dist/${PN}-${PV}.tar.gz \
	file://install-no-owner.patch;patch=1"

inherit autotools
