# Beecrypt OE build file
# Copyright (C) 2004-2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="Beecrypt is a general-purpose cryptography library."
HOMEPAGE="http://sourceforge.net/projects/beecrypt"
SRC_URI="${SOURCEFORGE_MIRROR}/beecrypt/beecrypt-${PV}.tar.gz"

PR = "r2"

inherit autotools
acpaths=""

EXTRA_OECONF="--with-arch=${TARGET_ARCH} --enable-shared --enable-static"

do_stage() {

#	oe_libinstall  -a  -C .libs libbeecrypt  ${STAGING_LIBDIR}
	cp .libs/libbeecrypt.a ${STAGING_LIBDIR}/
	install -d ${STAGING_INCDIR}/
	install -d ${STAGING_INCDIR}/beecrypt
	for X in beecrypt.h beecrypt.api.h memchunk.h mpnumber.h beecrypt.gnu.h mp.h mpopt.h blockmode.h endianness.h
	do
		install -m 0644 ${X} ${STAGING_INCDIR}/beecrypt/${X}
	done

}

