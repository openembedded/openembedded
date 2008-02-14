require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mpc8313e-rdb = "1"

DEPENDS_append_mpc8313e-rdb = " dtc-native"

PR = "r0"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.24.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/projects/rt/patch-2.6.24-rt1.bz2;patch=1 \
           file://defconfig \
	   "

S = "${WORKDIR}/linux-2.6.24"

#SRC_URI_append_mpc8313e-rdb = "\
#	file://mpc8313e-rdb-leds.patch;patch=1"
#	file://mpc831x-nand.patch;patch=1 \
#	file://mpc8313e-rdb-rtc.patch;patch=1 "

DEVICETREE_mpc8313e-rdb = "arch/${ARCH}/boot/dts/mpc8313erdb.dts"
DEVICETREE_FLAGS_mpc8313e-rdb = "-R 8 -S 0x3000"

do_devicetree_image() {
        if test -n "${DEVICETREE}" ; then
            dtc -I dts -O dtb ${DEVICETREE_FLAGS} -o ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_BASE_NAME}.dtb ${DEVICETREE}

            cd ${DEPLOY_DIR_IMAGE}
            rm -f ${KERNEL_IMAGE_SYMLINK_NAME}.dtb
            ln -sf ${KERNEL_IMAGE_BASE_NAME}.dtb ${KERNEL_IMAGE_SYMLINK_NAME}.dtb
        fi
}

addtask devicetree_image after do_deploy before do_package

