DESCRIPTION = "Squashfs is a highly compressed read-only filesystem for Linux."
SECTION = "base"
LICENSE = "GPLv2"
DEPENDS = "lzma"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/squashfs/squashfs${@bb.data.getVar('PV',d,1).replace('r','-r')}.tar.gz \
	   file://Makefile-3.1.patch;patch=1 \
           file://squashfs3.1r2-tools-replace_zlib_with_lzma.patch;patch=1 \
           file://squashfs3.1r2-tools-lzma_Makefile.patch;patch=1"

S = "${WORKDIR}/squashfs${@bb.data.getVar('PV',d,1).replace('r','-r')}/squashfs-tools"

prefix = ""

do_compile() {
	oe_runmake mksquashfs-lzma
}

do_install () {
	install -d ${D}${sbindir}
	install -m 0755 mksquashfs-lzma ${D}${sbindir}/
}
