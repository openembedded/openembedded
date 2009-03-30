SRC_URI = "file://90-check-modules.sh"
PR = "r0"
DESCRIPTION = "An initramfs module for checking that kernel modules exist in rootfs"
RDEPENDS = "initramfs-uniboot"

do_install() {
	install -d ${D}/initrd.d
        install -m 0755 ${WORKDIR}/90-check-modules.sh ${D}/initrd.d/
}

PACKAGE_ARCH = "all"
FILES_${PN} += " /initrd.d/* "
