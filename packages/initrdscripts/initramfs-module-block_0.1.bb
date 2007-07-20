SRC_URI = "file://blockboot.sh"
PR = "r0"
RDEPENDS = "initramfs"
DESCRIPTION = "An initramfs module for booting off normal block devices."

do_install() {
        install -m 0755 ${WORKDIR}/blockboot.sh ${D}/initrd.d/block
}

FILES_${PN} += " /initrd.d/block "
