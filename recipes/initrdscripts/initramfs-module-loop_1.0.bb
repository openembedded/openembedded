SRC_URI = "file://80-loopboot.sh"
PR = "r3"
DESCRIPTION = "An initramfs module for booting a filesystem image by loopback \
               mounting it."
RDEPENDS_${PN} = "initramfs-uniboot initramfs-module-initfs"
RRECOMMENDS_${PN} = "kernel-module-loop kernel-module-vfat"

do_install() {
	install -d ${D}/initrd.d
        install -m 0755 ${WORKDIR}/80-loopboot.sh ${D}/initrd.d/
}

PACKAGE_ARCH = "all"
FILES_${PN} += " /initrd.d/* "
