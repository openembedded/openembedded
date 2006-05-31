# libaio .bb build file
# Copyright (C) 2005-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

DESCRIPTION="Asynchronous input/output library that uses the kernels native interface"
HOMEPAGE="https://rhn.redhat.com/errata/RHBA-2005-085.html"
MAINTAINER = "Raymond Danks <info-linux@geode.amd.com>"
LICENSE="GPL"

SRC_URI="http://search.belnet.be/packages/lineox/4.0/updates/SRPMS/${P}-3.src.rpm \
file://${P}-more-arches.patch;patch=1"

S=${WORKDIR}/${P}

FILES_${PN} = "/usr"

inherit kernel-arch

DEPENDS_append = " rpm2cpio-native"

do_unpack() {
	
	if ! test -f libaio-${PV}.tar.gz ; then
		rpm2cpio.pl ${DL_DIR}/${P}-3.src.rpm | cpio -i --make-directories
		tar xzvf libaio-${PV}.tar.gz
	fi
}

do_stage () {
	#make install prefix='${STAGING_DIR}/${TARGET_SYS}' 
        install -D -m 644 src/libaio.h ${STAGING_DIR}/${TARGET_SYS}/include/libaio.h
	oe_libinstall -so -C src libaio ${STAGING_LIBDIR}
					
}

do_install () {
	make install prefix='${D}/usr' 
}
