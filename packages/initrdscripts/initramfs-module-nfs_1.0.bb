SRC_URI = "file://80-nfsboot.sh"
PR = "r0"
DESCRIPTION = "An initramfs module for booting via NFS."
RDEPENDS = "initramfs-uniboot"
RRECOMMENDS = "kernel-module-g-ether kernel-module-nfs"

do_install() {
	install -d ${D}/initrd.d
        install -m 0755 ${WORKDIR}/80-nfsboot.sh ${D}/initrd.d/
}

FILES_${PN} += " /initrd.d/nfs "
