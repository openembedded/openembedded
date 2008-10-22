SRC_URI = "file://85-blockboot.sh"
PR = "r3"
RDEPENDS = "initramfs-uniboot"
DESCRIPTION = "An initramfs module for booting off normal block devices."

do_install() {
	install -d ${D}/initrd.d
        install -m 0755 ${WORKDIR}/85-blockboot.sh ${D}/initrd.d/
}

PACKAGE_ARCH = "all"
FILES_${PN} += " /initrd.d/* "
