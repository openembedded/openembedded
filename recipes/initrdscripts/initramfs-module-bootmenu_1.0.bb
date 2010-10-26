SRC_URI = "file://30-bootmenu.sh"
PR = "r20"
DESCRIPTION = "An initramfs module with UI for selection of boot device."
RDEPENDS_${PN} = "klibc-static-utils-fstype initramfs-uniboot initramfs-module-block initramfs-module-loop initramfs-module-nfs"
# For VFAT mounting.
RRECOMMENDS_${PN} = "kernel-module-nls-cp437 kernel-module-nls-iso8859-1"

do_install() {
	install -d ${D}/initrd.d
        install -m 0755 ${WORKDIR}/30-bootmenu.sh ${D}/initrd.d/
}

PACKAGE_ARCH = "all"
FILES_${PN} += " /initrd.d/* "
