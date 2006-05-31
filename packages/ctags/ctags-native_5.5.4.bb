# ctags-native OE build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="Ctags generates an index (or tag) file of language objects found in source files."
LICENSE="GPL"
MAINTAINER = "Raymond Danks <info-linux@geode.amd.com>"
HOMEPAGE="http://ctags.sourceforge.net/"

SRC_URI="${SOURCEFORGE_MIRROR}/ctags/ctags-${PV}.tar.gz"

S="${WORKDIR}/ctags-${PV}"

inherit native
inherit autotools
