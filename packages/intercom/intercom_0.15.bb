# intercom OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="A flexible audio communication utility"

SRC_URI="http://mirror.optusnet.com.au/sourceforge/i/in/intercom/intercom-${PV}.tar.gz"
LICENSE="GPL"

inherit autotools
EXTRA_OECONF="--disable-crypto --with-cpu=${TARGET_ARCH}"

