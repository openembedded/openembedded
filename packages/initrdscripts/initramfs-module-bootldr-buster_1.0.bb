SRC_URI = "file://01-bootldr-buster.sh"
PR = "r2"
DESCRIPTION = "An initramfs module for ignoring bogus kernel commandline from Compaq bootldr"
RDEPENDS = "initramfs-uniboot"

do_install() {
	install -d ${D}/initrd.d
        install -m 0755 ${WORKDIR}/01-bootldr-buster.sh ${D}/initrd.d/
}

PACKAGE_ARCH = "all"
FILES_${PN} += " /initrd.d/* "
