SECTION = "libs"
DESCRIPTION = "File locking library."
LICENSE = "LGPL"
SRC_URI = "${DEBIAN_MIRROR}/main/libl/liblockfile/liblockfile_${PV}.tar.gz \
	   file://install.patch;patch=1 \
	   file://configure.patch;patch=1 \
	   file://ldflags.patch;patch=1"

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
