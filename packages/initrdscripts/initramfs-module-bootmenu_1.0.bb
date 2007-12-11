SRC_URI = "file://30-bootmenu.sh"
PR = "r3"
RDEPENDS = "klibc-utils-fstype initramfs-uniboot initramfs-module-block initramfs-module-loop"
DESCRIPTION = "An initramfs module with UI for selection of boot device."

do_install() {
	install -d ${D}/initrd.d
        install -m 0755 ${WORKDIR}/30-bootmenu.sh ${D}/initrd.d/
}

PACKAGE_ARCH = "all"
FILES_${PN} += " /initrd.d/* "
