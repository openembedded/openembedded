DESCRIPTION = "A simple and easy to use Linux kernel (2.4+) module which allows you to mount remote filesystems using plain shell (ssh/rsh) connection. \
It supports some nice features like number of different caches for access speedup, target system optimisations, etc."
SECTION = "kernel/userland"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
RDEPENDS = "shfs-modules (${PV})"
DEPENDS = "virtual/kernel"

SRC_URI = "${SOURCEFORGE_MIRROR}/shfs/shfs-${PV}.tar.gz"
S = "${WORKDIR}/shfs-${PV}/shfsmount"

KERNEL_VERSION = "${@base_read_file('${STAGING_KERNEL_DIR}/kernel-abiversion')}"
KV = "${@base_read_file('${STAGING_KERNEL_DIR}/kernel-abiversion')[:3]}"

CFLAGS_append=' -DVERSION=\\"${KERNEL_VERSION}\\" -DSHFS_VERSION=\\"${PV}\\" -I../shfs/Linux-${KV}'

do_compile() {
        oe_runmake LINKER="${CC}"
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 shfsmount shfsumount ${D}${bindir}
}
