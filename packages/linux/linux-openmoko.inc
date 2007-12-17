# extra stuff we need for openmoko that is not in linux.inc
do_deploy_append() {
	mv ${DEPLOY_DIR_IMAGE}/modules-${PV}-${PR}-${MACHINE}.tgz ${DEPLOY_DIR_IMAGE}/modules-${PV}-${PR}-${MACHINE_CLASS}.tgz
	mv ${DEPLOY_DIR_IMAGE}/uImage-${PV}-${PR}-${MACHINE}.bin ${DEPLOY_DIR_IMAGE}/uImage-${PV}-${PR}-${MACHINE_CLASS}.bin
	rm -f ${KERNEL_IMAGE_SYMLINK_NAME}.bin
	ln -sf ${DEPLOY_DIR_IMAGE}/uImage-${PV}-${PR}-${MACHINE_CLASS}.bin ${DEPLOY_DIR_IMAGE}/uImage-${MACHINE_CLASS}-latest.bin
}

RDEPENDS_kernel-image += "mtd-utils"

pkg_postinst_kernel-image () {
if test "x$D" != "x"; then
        exit 1
else
	echo "Upgrading Kernel in Flash"
	echo "DO NOT stop this process"

	${bindir}/flash_eraseall ${MTD_KERNEL_PARTITION}
	${bindir}/nandwrite -p ${MTD_KERNEL_PARTITION} /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${KERNEL_VERSION}
fi
}

