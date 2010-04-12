# mtools OE build file
# Copyright (C) 2004-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Copyright (C) 2009, O.S. Systems Software Ltda. All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="Mtools is a collection of utilities for accessing MS-DOS disks from Unix without mounting them."
HOMEPAGE="http://mtools.linux.lu"
LICENSE="GPL"

SRC_URI="http://ftp.gnu.org/gnu/mtools/mtools-${PV}.tar.bz2 \
	file://m486.patch;patch=1 \
	file://mtools-makeinfo.patch;patch=1 \
	file://plainio.patch;patch=1 \
	file://use-sg_io.patch;patch=1"

PR = "r1"

inherit autotools

EXTRA_OECONF = "--without-x"

# Don't try to run install-info -- it'll fail on non-Debian build systems.
EXTRA_OEMAKE = "INSTALL_INFO="

do_fix_perms() {
	chmod 644 ${S}/*.c ${S}/*.h
}

addtask fix_perms after do_unpack before do_patch

SRC_URI[md5sum] = "750c2beba968a5d46dbaae24551a82b9"
SRC_URI[sha256sum] = "860fee13acb39365bd28763070e24011ea55f381f96714d2841937525aa02ded"
