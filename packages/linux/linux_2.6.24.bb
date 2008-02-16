require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_gesbc-9302 = "1"
DEFAULT_PREFERENCE_mpc8313e-rdb = "1"

DEPENDS_append_mpc8313e-rdb = " dtc-native"

PR = "r5"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.24.tar.bz2 \
           http://kamikaze.waninkoko.info/patches/2.6.24/kamikaze1/broken-out/squashfs-lzma-2.6.24.patch;patch=1 \
           file://powerpc-clockres.patch;patch=1 \
           file://defconfig"

# Real-time preemption. This is experimental and requires a different defconfig.
#SRC_URI += " http://www.kernel.org/pub/linux/kernel/projects/rt/patch-2.6.24-rt1.bz2;patch=1"

SRC_URI_append_gesbc-9302 = " \
	file://0001-gesbc-nand.patch;patch=1 \
	file://0002-gesbc-eth-platform.patch;patch=1 \
	file://0005-ep93xx-reboot.patch;patch=1 \
	"

SRC_URI_append_mpc8313e-rdb = "\
	file://mpc8313e-rdb-leds.patch;patch=1 \
	file://mpc8313e-rdb-rtc.patch;patch=1"

CMDLINE_gesbc-9302 = "console=ttyAM0 root=mtd5 rootfstype=jffs2 mtdparts=GESBC-NAND:64m(app),-(data)"

FILES_kernel-image_gesbc-9302 = ""

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

