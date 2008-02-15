DESCRIPTION = "Boot initramfs as a package"
PR = "r1"

do_compile() {
	cd ${TOPDIR}; DISTRO=${USERDISTRO} MACHINE=${MACHINE} ANGSTROM_MODE=uclibc IMAGE_FSTYPES=cpio.gz DEPLOY_TO=${D}/boot/initramfs.bin bitbake initramfs-image
}

do_install() {
	install -d ${D}/boot/
	cd ${TOPDIR}; DISTRO=${USERDISTRO} MACHINE=${MACHINE} ANGSTROM_MODE=uclibc IMAGE_FSTYPES=cpio.gz DEPLOY_TO=${D}/boot/initramfs.bin bitbake initramfs-image -c deploy_to
}

FILES_${PN} += "/boot/*"

PACKAGE_ARCH = "${MACHINE_ARCH}"
