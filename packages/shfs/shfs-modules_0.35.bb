DESCRIPTION = "A simple and easy to use Linux kernel (2.4+) module which allows you to mount remote filesystems using plain shell (ssh/rsh) connection. \
It supports some nice features like number of different caches for access speedup, target system optimisations, etc."
SECTION = "kernel/modules"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/shfs/shfs-${PV}.tar.gz"
S = "${WORKDIR}/shfs-${PV}/shfs/Linux-2.4"

#FIXME depend S on kernel version

inherit module

do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
        oe_runmake KERNEL_SOURCES=${STAGING_KERNEL_DIR} KERNEL=${KERNEL_VERSION} \
                   CC="${KERNEL_CC}" LD="${KERNEL_LD}" LINKER="${KERNEL_LD}" LDFLAGS=-r
}

do_stage() {
	install -m 0644 shfs_fs.h shfs.h ${STAGING_INCDIR}/
}

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/fs/shfs/
	install -m 0644 shfs.o ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/fs/shfs/shfs.o
}
