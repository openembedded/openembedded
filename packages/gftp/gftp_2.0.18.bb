# gftp OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

HOMEPAGE="http://www.gftp.org/"
LICENSE="GPL"

SRC_URI="http://www.gftp.org/gftp-${PV}.tar.bz2 \
	 file://configure.patch;patch=1"

DEPENDS="gtk+ openssl"

inherit autotools

EXTRA_OECONF="--disable-textport"
