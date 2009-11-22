DESCRIPTION = "Squashfs is a highly compressed read-only filesystem for Linux."
SECTION = "base"
LICENSE = "GPLv2"
DEPENDS = "zlib"
INC_PR = "r3"

S = "${WORKDIR}/squashfs${@bb.data.getVar('PV',d,1).replace('r','-r')}/squashfs-tools"

# required to share same place with -lzma specific packages
FILESPATHPKG = "squashfs-tools-${PV}:squashfs-tools:files"

SRC_URI ?= "${SOURCEFORGE_MIRROR}/squashfs/squashfs${@bb.data.getVar('PV',d,1).replace('r','-r')}.tar.gz"

prefix = ""

do_compile() {
	oe_runmake mksquashfs
}

do_install () {
	install -d ${D}${sbindir}
	install -m 0755 mksquashfs ${D}${sbindir}/
}
