DESCRIPTION = "Tools for managing memory technology devices."
SECTION = "base"
DEPENDS = "zlib lzo"
HOMEPAGE = "http://www.linux-mtd.infradead.org/"
LICENSE = "GPLv2"
PR = "r1"

# scheduled to enable 15-03-2008
DEFAULT_PREFERENCE = "-1"

SRC_URI = "ftp://ftp.infradead.org/pub/mtd-utils/mtd-utils-1.1.0.tar.bz2 \
           file://add-exclusion-to-mkfs-jffs2-git.patch;patch=1 \
	   file://fix-ignoreerrors-git.patch;patch=1 \
	   file://lzo_1x.patch;patch=1"

S = "${WORKDIR}/mtd-utils-${PV}/"

EXTRA_OEMAKE = "'CC=${CC}' 'CFLAGS=${CFLAGS} -I${S}/include -DWITHOUT_XATTR'"

do_stage () {
	install -d ${STAGING_INCDIR}/mtd
	for f in ${S}/include/mtd/*.h; do
		install -m 0644 $f ${STAGING_INCDIR}/mtd/
	done
	for binary in ${mtd_utils}; do
		install -m 0755 $binary ${STAGING_BINDIR}
	done
}

mtd_utils = "ftl_format flash_erase flash_eraseall nanddump doc_loadbios \
             mkfs.jffs ftl_check mkfs.jffs2 flash_lock flash_unlock flash_info mtd_debug \
             flashcp nandwrite jffs2dump sumtool"

do_install () {
	install -d ${D}${bindir}
	install -d ${D}${includedir}
	for binary in ${mtd_utils}; do
		install -m 0755 $binary ${D}${bindir}
	done
	for f in ${S}/include/mtd/*.h; do
		install -m 0644 $f ${D}${includedir}
	done
}

PACKAGES =+ "mkfs-jffs mkfs-jffs2"
FILES_mkfs-jffs = "${bindir}/mkfs.jffs"
FILES_mkfs-jffs2 = "${bindir}/mkfs.jffs2"

