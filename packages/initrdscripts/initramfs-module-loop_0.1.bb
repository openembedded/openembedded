SRC_URI = "file://loopboot.sh"
PR = "r2"
DESCRIPTION = "An initramfs module for booting a filesystem image by loopback \
               mounting it."
RDEPENDS = "initramfs-uniboot"
RRECOMMENDS = "kernel-module-loop kernel-module-vfat"

do_install() {
        install -m 0755 ${WORKDIR}/loopboot.sh ${D}/initrd.d/loop
}

FILES_${PN} += " /initrd.d/loop "
