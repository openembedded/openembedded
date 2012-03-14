DESCRIPTION = "File locking library."
SECTION = "libs"
LICENSE = "LGPL"
PR ="r1"

SRC_URI = "http://snapshot.debian.org/archive/debian/20050312T000000Z/pool/main/libl/liblockfile/liblockfile_${PV}.tar.gz \
	   file://install.patch \
	   file://configure.patch \
	   file://ldflags.patch \
	   file://glibc-2.4.patch"

inherit autotools

EXTRA_OECONF = "--enable-shared --enable-static"

do_stage () {
	install -m 644 ${S}/lockfile.h ${S}/maillock.h ${STAGING_INCDIR}/
	oe_libinstall -a -so liblockfile ${STAGING_LIBDIR}
#	oe_libinstall -so nfslock ${STAGING_LIBDIR}
}

do_install () {
	oe_runmake 'ROOT=${D}' INSTGRP='' install
}

SRC_URI[md5sum] = "2de88389da013488bfd31356523070c0"
SRC_URI[sha256sum] = "14f9690328318d11f9ba13a9356a2c008bdd169b7a817f38cb7f9eb32cf7240e"
