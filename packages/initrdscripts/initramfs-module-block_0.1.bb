SRC_URI = "file://blockboot.sh"
PR = "r3"
RDEPENDS = "initramfs-uniboot"
DESCRIPTION = "An initramfs module for booting off normal block devices."

do_install() {
	install -d ${D}/initrd.d
        install -m 0755 ${WORKDIR}/85-blockboot.sh ${D}/initrd.d/
}

FILES_${PN} += " /initrd.d/block "
