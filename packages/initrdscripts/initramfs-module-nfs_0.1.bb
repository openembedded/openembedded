SRC_URI = "file://nfsboot.sh"
PR = "r4"
DESCRIPTION = "An initramfs module for booting via NFS."
RDEPENDS = "initramfs-uniboot"
RRECOMMENDS = "kernel-module-g-ether kernel-module-nfs"

do_install() {
	install -d ${D}/initrd.d
        install -m 0755 ${WORKDIR}/nfsboot.sh ${D}/initrd.d/nfs
}

FILES_${PN} += " /initrd.d/nfs "
