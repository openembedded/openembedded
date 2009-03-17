# intercom OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="A flexible audio communication utility"
SECTION = "console/telephony"
LICENSE="GPL"

PR = "r1"

SRC_URI="ftp://ftp.cm.nu/pub/people/shane/intercom/intercom-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF="--disable-crypto --with-cpu=${TARGET_ARCH}"
