SRC_URI = "file://10-initfs.sh"
PR = "r5"
DESCRIPTION = "An initramfs module for initializing filesystems."
RDEPENDS_${PN} = "initramfs-uniboot"
RRECOMMENDS_${PN} = "kernel-module-vfat kernel-module-ext2"

do_install() {
	install -d ${D}/initrd.d
        install -m 0755 ${WORKDIR}/10-initfs.sh ${D}/initrd.d/
}

PACKAGE_ARCH = "all"
FILES_${PN} += " /initrd.d/* "
