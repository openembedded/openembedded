# ctags-native OE build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="Ctags generates an index (or tag) file of language objects found in source files."
LICENSE="GPL"
HOMEPAGE="http://ctags.sourceforge.net/"

SRC_URI="${SOURCEFORGE_MIRROR}/ctags/ctags-${PV}.tar.gz"

S="${WORKDIR}/ctags-${PV}"

inherit native
inherit autotools

SRC_URI[md5sum] = "a84124caadd4103270e0b84596ecfe83"
SRC_URI[sha256sum] = "7b83689a47efa627d4b5670317125de3d87ae9278cf69c3ac7e3b7be646e715d"
