SRC_URI = "file://loopboot.sh"
PR = "r4"
DESCRIPTION = "An initramfs module for booting a filesystem image by loopback \
               mounting it."
RDEPENDS = "initramfs-uniboot"
RRECOMMENDS = "kernel-module-loop kernel-module-vfat"

do_install() {
	install -d ${D}/initrd.d
        install -m 0755 ${WORKDIR}/80-loopboot.sh ${D}/initrd.d/
}

FILES_${PN} += " /initrd.d/loop "
