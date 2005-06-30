# grip OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

HOMEPAGE="http://www.nostatic.org/grip/"
LICENSE="GPL"

SRC_URI="${SOURCEFORGE_MIRROR}/grip/grip-${PV}.tar.gz"
DEPENDS="libgnomeui vte curl cdparanoia id3lib"

inherit autotools 
