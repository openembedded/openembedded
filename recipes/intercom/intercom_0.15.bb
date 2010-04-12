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

SRC_URI[md5sum] = "11d11d1e5ec6dd9ec22bb0bd85b0e5c7"
SRC_URI[sha256sum] = "734ff159feedf6198889d4daba233347ff7966e8fd6c22a89c9087c1c85cc5c3"
