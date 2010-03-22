# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="A cd-player and cd-ripper for the Gnome desktop"
HOMEPAGE="http://www.nostatic.org/grip/"
LICENSE="GPL"

SRC_URI="${SOURCEFORGE_MIRROR}/${PN}/${PV}/${P}.tar.gz;name=grip \
         file://no-host-includes.patch;patch=1 "
SRC_URI[grip.md5sum] = "4b4233999b9f2bc85c711092553ea9aa"
SRC_URI[grip.sha256sum] = "d46394a1062ed066f9c633b010fd1059e63d9ed791bbb7a85bc6567cf0fd66fd"

DEPENDS="libgnomeui vte curl cdparanoia id3lib"

PR = "r0"

inherit autotools
