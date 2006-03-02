# rdesktop OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "RDesktop is a X11 based RDP client"
HOMEPAGE = "http://www.rdesktop.org/"
LICENSE = "GPL"
DEPENDS = "libx11 openssl"
RDEPENDS= "openssl"
SECTION = "x11/network"

SRC_URI="${SOURCEFORGE_MIRROR}/rdesktop/rdesktop-${PV}.tar.gz \
	file://configure.patch;patch=1"

# Note - rdesktop 1.3.1 doesn't use autotools - don't make the same
# mistakes I did.. :)

do_configure() {
	${S}/configure \
	--prefix=${prefix} \
	--exec-prefix=${exec_prefix} \
	--bindir=${bindir} \
	--mandir=${mandir} \
	--sharedir=${datadir} \
	--with-x=${STAGING_DIR}/${HOST_SYS} \
	--with-openssl=${STAGING_DIR}/${HOST_SYS} \
	--with-oss \
	--without-debug	 
}

do_compile() {
	oe_runmake 'KEYMAP_PATH=${datadir}/keymaps/' 
}

do_install() {
	oe_runmake DESTDIR=${D} install
}
