DESCRIPTION = "Tools for managing memory technology devices."
SECTION = "base"
DEPENDS = "zlib"
HOMEPAGE = "http://www.linux-mtd.infradead.org/"
LICENSE = "GPLv2"
PR = "r2"
SRCDATE = "20041113"

SRC_URI = "cvs://anoncvs:anoncvs@cvs.infradead.org/home/cvs;module=mtd \
           file://add-exclusion-to-mkfs-jffs2-20041113.patch;patch=1" \
           file://target-endian.patch;patch=1"

S = "${WORKDIR}/mtd"


CFLAGS_prepend = "-I${S}/include "

do_compile () {
	oe_runmake -C util
}

do_stage () {
	install -d ${STAGING_INCDIR}/mtd
	for f in ${S}/include/mtd/*.h; do
		install -m 0644 $f ${STAGING_INCDIR}/mtd/
	done
}

do_install () {
	install -d ${D}${bindir}
	for binary in ftl_format flash_erase flash_eraseall nanddump doc_loadbios \
		      mkfs.jffs ftl_check mkfs.jffs2 flash_lock flash_unlock flash_info mtd_debug \
		      flashcp nandwrite jffs2dump; do
		install -m 0755 util/$binary ${D}${bindir}
	done
}
