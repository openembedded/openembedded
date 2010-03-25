DESCRIPTION = "JFS Filesystem Utilities"
HOMEPAGE = "http://jfs.sourceforge.net/"
LICENSE = "GPL"
SECTION = "base"
PR = "r0"
DEPENDS = "util-linux-ng"

SRC_URI = "http://jfs.sourceforge.net/project/pub/${PN}-${PV}.tar.gz"

inherit autotools

# Fix duplicates
do_install_append() {
	rm -f ${D}/usr/sbin/mkfs.jfs ${D}/usr/sbin/fsck.jfs
	ln -sf /usr/sbin/jfs_fsck ${D}/usr/sbin/fsck.jfs
	ln -sf /usr/sbin/jfs_mkfs ${D}/usr/sbin/mkfs.jfs
}
