DESCRIPTION = "Squashfs is a highly compressed read-only filesystem for Linux."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
DEPENDS = "lzma"
SECTION = "base"
LICENSE = "GPLv2"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/squashfs/squashfs${@bb.data.getVar('PV',d,1).replace('r','-r')}.tar.gz \
	   file://Makefile-2.2.patch;patch=1 \
	   file://squashfs2.0-tools-lzma.patch;patch=1"
S = "${WORKDIR}/squashfs${@bb.data.getVar('PV',d,1).replace('r','-r')}/squashfs-tools"

prefix = ""

do_compile() {
	oe_runmake mksquashfs mksquashfs-lzma
}

do_install () {
	install -d ${D}${sbindir}
	install -m 0755 mksquashfs ${D}${sbindir}/
	install -m 0755 mksquashfs-lzma ${D}${sbindir}/
}
