# grip OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

HOMEPAGE="http://www.nostatic.org/grip/"
LICENSE="GPL"

SRC_URI="${SOURCEFORGE_MIRROR}/grip/grip-${PV}.tar.gz \
         file://patch-src::discdb;patch=1;pnum=0 \
         file://patch-src::main.c;patch=1;pnum=0 \
         file://no-host-includes.patch;patch=1 "
DEPENDS="libgnomeui vte curl cdparanoia id3lib"

PR = "r3"

inherit autotools
