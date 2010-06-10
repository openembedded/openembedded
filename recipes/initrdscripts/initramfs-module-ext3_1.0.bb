SRC_URI = "file://80-ext3.sh"
PR = "r2"
DESCRIPTION = "An initramfs module for mount ext3."
RDEPENDS_${PN} = "initramfs-uniboot"

do_install() {
    install -d ${D}/initrd.d
    install -m 0755 ${WORKDIR}/80-ext3.sh ${D}/initrd.d/
}

PACKAGE_ARCH = "all"
FILES_${PN} += " /initrd.d/* "
