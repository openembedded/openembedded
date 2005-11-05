DESCRIPTION = "EXT2 Filesystem Utilities"
LICENSE = "GPL"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Greg Gilbert <greg@treke.net>"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/e2fsprogs/e2fsprogs-${PV}.tar.gz \
	   file://ln.patch;patch=1 \
	   file://configure.patch;patch=1 \
	   file://compile-subst.patch;patch=1 \
	   file://m4.patch;patch=1 \
	   file://ldflags.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--enable-dynamic-e2fsck"

sbindir = "/sbin"

PACKAGES_prepend = "e2fsprogs-e2fsck e2fsprogs-mke2fs e2fsprogs-fsck "
FILES_e2fsprogs-fsck = "${sbindir}/fsck"
FILES_e2fsprogs-e2fsck = "${sbindir}/e2fsck ${sbindir}/fsck.ext2 ${sbindir}/fsck.ext3"
FILES_e2fsprogs-mke2fs = "${sbindir}/mke2fs ${sbindir}/mkfs.ext2 ${sbindir}/mkfs.ext3"

do_compile_prepend () {
	find ./ -print|xargs chmod u=rwX
	( cd util; ${BUILD_CC} subst.c -o subst )
}

ext2fsheaders = "ext2_ext_attr.h bitops.h ext2_err.h \
		 ext2_types.h ext2_fs.h ext2_io.h \
		 ext2fs.h"
e2pheaders = "e2p.h"
do_stage () {
	oe_libinstall -a -C lib libe2p ${STAGING_LIBDIR}/
	oe_libinstall -a -C lib libext2fs ${STAGING_LIBDIR}/
	install -d ${STAGING_INCDIR}/e2p
	for h in ${e2pheaders}; do
		install -m 0644 lib/e2p/$h ${STAGING_INCDIR}/e2p/ || die "failed to install $h"
	done
	install -d ${STAGING_INCDIR}/ext2fs
	for h in ${ext2fsheaders}; do
		install -m 0644 lib/ext2fs/$h ${STAGING_INCDIR}/ext2fs/ || die "failed to install $h"
	done
}
