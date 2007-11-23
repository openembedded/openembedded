SRC_URI = "file://10-initfs.sh"
PR = "r1"
DESCRIPTION = "An initramfs module for initializing filesystems."
RDEPENDS = "initramfs-uniboot"
RRECOMMENDS = "kernel-module-vfat kernel-module-ext2"

do_install() {
	install -d ${D}/initrd.d
        install -m 0755 ${WORKDIR}/10-initfs.sh ${D}/initrd.d/
}

FILES_${PN} += " /initrd.d/* "
