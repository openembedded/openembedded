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

SRC_URI[md5sum] = "9b51933a03dd7d7ddfbb3643fc82c2d0"
SRC_URI[sha256sum] = "5a51a67f2828aa679a46bbb95cdc5346d6d4516f8ba74b7744b6049ccbe805ca"
