DESCRIPTION = "Squashfs is a highly compressed read-only filesystem for Linux."
SECTION = "base"
LICENSE = "GPLv2"
DEPENDS = "zlib"
PR = "r2"

# 2009-10-22 snapshot
#SRC_URI = "http://www.kernel.org/pub/linux/kernel/people/pkl/squashfs4.0-lzma-snapshot.tgz"
#S = "${WORKDIR}/squashfs4.0-lzma-snapshot/squashfs-tools"

SRC_URI  = "cvs://anonymous@squashfs.cvs.sourceforge.net/cvsroot/squashfs;module=squashfs;date=${SRCDATE}"
S = "${WORKDIR}/squashfs/squashfs-tools"

SRC_URI += "http://downloads.sourceforge.net/sevenzip/lzma465.tar.bz2"

COMP_DEFAULT = gzip

EXTRA_OEMAKE += "LZMA_SUPPORT=1 LZMA_DIR=../.."

TARGET_CC_ARCH += "${LDFLAGS}"

# the COMP_DEFAULT macro should result in a string including quotes: "gzip"
CFLAGS_append = ' -I. -I../../C -D_FILE_OFFSET_BITS=64 -D_LARGEFILE_SOURCE \
 -D_GNU_SOURCE -DLZMA_SUPPORT -DCOMP_DEFAULT=\\"${COMP_DEFAULT}\\" '

prefix = ""

do_compile() {
	oe_runmake mksquashfs
}

do_install () {
	install -d ${D}${sbindir}
	install -m 0755 mksquashfs ${D}${sbindir}/
}

