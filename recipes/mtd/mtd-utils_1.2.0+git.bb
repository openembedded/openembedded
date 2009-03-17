DESCRIPTION = "Tools for managing memory technology devices."
SECTION = "base"
DEPENDS = "e2fsprogs-libs zlib lzo"
HOMEPAGE = "http://www.linux-mtd.infradead.org/"
LICENSE = "GPLv2"
PR = "r3"

ARM_INSTRUCTION_SET = "arm"

# This is the default package, thus we lock to a specific git version so 
# upstream changes will not break builds.

TAG = "ea429635388f7bb53f62c41ec3d5ccf5fa207370"

SRC_URI = "git://git.infradead.org/mtd-utils.git;protocol=git;tag=${TAG} \
	   file://add-exclusion-to-mkfs-jffs2-git-2.patch;patch=1 \
	   file://fix-ignoreerrors-git.patch;patch=1 \
	   file://lzo_1x-git.patch;patch=1"

S = "${WORKDIR}/git/"

EXTRA_OEMAKE = "'CC=${CC}' 'CFLAGS=${CFLAGS} -I${S}/include -DWITHOUT_XATTR'"

do_configure_prepend() {
	for i in $(find . -name "Makefile") ; do
		sed -i -e s:lzo2:lzo:g $i
	done
	sed -i -e s:lzo/::g mkfs.ubifs/compr.c
}

do_stage () {
	install -d ${STAGING_INCDIR}/mtd
	for f in ${S}/include/mtd/*.h; do
		install -m 0644 $f ${STAGING_INCDIR}/mtd/
	done
	for binary in ${mtd_utils}; do
		install -m 0755 $binary ${STAGING_BINDIR}
	done
}

mtd_utils = " docfdisk \
	doc_loadbios \
	flashcp \
	flash_erase \
	flash_eraseall \
	flash_info \
	flash_lock \
	flash_otp_dump \
	flash_otp_info \
	flash_unlock \
	ftl_check \
	ftl_format \
	jffs2dump \
	mkfs.jffs2 \
	mtd_debug \
	nanddump \
	nandtest \
	nandwrite \
	nftldump \
	nftl_format \
	recv_image \
	rfddump \
	rfdformat \
	serve_image \
	sumtool \
	mkfs.ubifs/mkfs.ubifs \
	ubi-utils/bin2nand \
	ubi-utils/mkbootenv \
	ubi-utils/nand2bin \
	ubi-utils/pddcustomize \
	ubi-utils/pfi2bin \
	ubi-utils/pfiflash \
	ubi-utils/ubigen \
	ubi-utils/ubimirror \
	ubi-utils/unubi \
	ubi-utils/new-utils/ubiattach \
	ubi-utils/new-utils/ubicrc32 \
	ubi-utils/new-utils/ubidetach \
	ubi-utils/new-utils/ubiformat \
	ubi-utils/new-utils/ubimkvol \
	ubi-utils/new-utils/ubinfo \
	ubi-utils/new-utils/ubinize \
	ubi-utils/new-utils/ubirmvol \
	ubi-utils/new-utils/ubiupdatevol"



do_install () {
	install -d ${D}${bindir}
	install -d ${D}${includedir}/mtd
	for binary in ${mtd_utils}; do
		install -m 0755 $binary ${D}${bindir}
	done
	for f in ${S}/include/mtd/*.h; do
		install -m 0644 $f ${D}${includedir}/mtd
	done
}

PACKAGES =+ "mkfs-jffs mkfs-jffs2"
FILES_mkfs-jffs = "${bindir}/mkfs.jffs"
FILES_mkfs-jffs2 = "${bindir}/mkfs.jffs2"

