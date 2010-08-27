# cdrtools-native OE build file
# Copyright (C) 2004-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

LICENSE="OSS"
DESCRIPTION="A set of tools for CD recording, including cdrecord"
HOMEPAGE="http://cdrecord.berlios.de/private/cdrecord.html"

SRC_URI="ftp://ftp.berlios.de/pub/cdrecord/cdrtools-3.00.tar.gz"
SRC_URI[md5sum] = "bb21cefefcfbb76cf249120e8978ffdd"
SRC_URI[sha256sum] = "6326762da8b8281c9a910c66fe698cd4d1bc5f33c37b59e8f1c83343c25f3e98"


S="${WORKDIR}/cdrtools-${PV}"
PR = "r0"

inherit native

do_install() {
	make install INS_BASE=${D}/${exec_prefix}
}

NATIVE_INSTALL_WORKS = "1"
