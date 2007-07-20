SRC_URI = "file://nfsboot.sh"
PR = "r2"
DESCRIPTION = "An initramfs module for booting via NFS."
RDEPENDS = "initramfs"
RRECOMMENDS = "kernel-module-g-ether kernel-module-nfs"

do_install() {
        install -m 0755 ${WORKDIR}/nfsboot.sh ${D}/initrd.d/nfs
}

FILES_${PN} += " /initrd.d/nfs "
