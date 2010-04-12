# syslinux-native OE build file
# Copyright (C) 2004-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Copyright (C) 2009, O.S. Systems Software Ltda.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

require syslinux_${PV}.bb
inherit native

STAGE_TEMP="${WORKDIR}/stage_temp"

do_stage() {
	install -d ${STAGE_TEMP}
	oe_runmake install INSTALLROOT="${STAGE_TEMP}"

	install -d ${STAGING_BINDIR}
	install -m 755 ${STAGE_TEMP}/${bindir}/syslinux ${STAGING_BINDIR}
	install -m 755 ${STAGE_TEMP}/${base_sbindir}/extlinux ${STAGING_BINDIR}

	install -d ${STAGING_DATADIR}/syslinux
	install -m 0644 ${STAGE_TEMP}/${datadir}/syslinux/isolinux.bin ${STAGING_DATADIR}/syslinux/isolinux.bin
	install -m 0644 ${STAGE_TEMP}/${datadir}/syslinux/mbr.bin ${STAGING_DATADIR}/syslinux/mbr.bin
	install -m 0644 ${S}/core/ldlinux.sys ${STAGING_DATADIR}/syslinux/ldlinux.sys
	install -m 0644 ${S}/core/ldlinux.bss ${STAGING_DATADIR}/syslinux/ldlinux.bss
}

SRC_URI[md5sum] = "c9f4e73e385c86b3a8faf9b615a04836"
SRC_URI[sha256sum] = "1dbbf8cfd10fc07187fa8bfede23639fc95314976730f3474cb349e8bf6c6f61"
