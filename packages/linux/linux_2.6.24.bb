require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_gesbc-9302 = "1"

PR = "r1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.24.tar.bz2 \
           file://defconfig \
	   "

S = "${WORKDIR}/linux-2.6.24"

SRC_URI_append_gesbc-9302 = " \
	file://0001-gesbc-nand.patch;patch=1 \
	file://0002-gesbc-eth-platform.patch;patch=1 \
	file://0005-ep93xx-reboot.patch;patch=1 \
	"

CMDLINE_gesbc-9302 = "console=ttyAM0 root=mtd5 rootfstype=jffs2 mtdparts=GESBC-NAND:64m(app),-(data)"

FILES_kernel-image_gesbc-9302 = ""

do_devicetree_image() {
        if test -n "${DEVICETREE}" ; then
            dtc -I dts -O dtb -o ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_BASE_NAME}.dtb ${DEVICETREE}

            cd ${DEPLOY_DIR_IMAGE}
            rm -f ${KERNEL_IMAGE_SYMLINK_NAME}.dtb
            ln -sf ${KERNEL_IMAGE_BASE_NAME}.dtb ${KERNEL_IMAGE_SYMLINK_NAME}.dtb
        fi
}

addtask devicetree_image after do_deploy before do_package

