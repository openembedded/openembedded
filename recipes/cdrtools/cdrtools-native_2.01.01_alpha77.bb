# cdrtools-native OE build file
# Copyright (C) 2004-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

LICENSE="OSS"
DESCRIPTION="A set of tools for CD recording, including cdrecord"
HOMEPAGE="http://cdrecord.berlios.de/private/cdrecord.html"

SRC_URI="http://ftp.berlios.de/pub/cdrecord/alpha/cdrtools-2.01.01a77.tar.bz2;name=src"
SRC_URI[src.md5sum] = "0564e79a18d9a6768dbbb02a7717c5ab"
SRC_URI[src.sha256sum] = "c007e72ec113503a30f26f7b344d95f804a72ff4981141e2a55fc2b32db324cc"

S="${WORKDIR}/cdrtools-${PV}"
PR = "r2"

inherit native

STAGE_TEMP="${WORKDIR}/stage_temp"

do_stage() {
	install -d ${STAGE_TEMP}
	make install INS_BASE=${STAGE_TEMP}

	install -d ${STAGING_BINDIR}
	install ${STAGE_TEMP}/bin/* ${STAGING_BINDIR}
}
