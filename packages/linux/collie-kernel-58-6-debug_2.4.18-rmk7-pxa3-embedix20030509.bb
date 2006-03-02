COLLIE_MEMORY_SIZE=58
COLLIE_RAMDISK_SIZE=6
KERNEL_CONSOLE = "tty0"

include ../linux/openzaurus-sa_2.4.18-rmk7-pxa3-embedix20030509.bb

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} \
	${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}-${COLLIE_MEMORY_SIZE}-${COLLIE_RAMDISK_SIZE}-DEBUG-${DATETIME}.bin
}
