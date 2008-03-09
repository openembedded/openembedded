SRC_URI = "file://87-kexecboot.sh"
PR = "r1"
DESCRIPTION = "An initramfs module for kexecing kernel from rootfs."
RDEPENDS = "initramfs-uniboot kexec-static"

do_install() {
	install -d ${D}/initrd.d
        install -m 0755 ${WORKDIR}/87-kexecboot.sh ${D}/initrd.d/
}

PACKAGE_ARCH = "all"
FILES_${PN} += " /initrd.d/* "
