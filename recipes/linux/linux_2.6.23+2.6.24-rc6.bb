require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

PR = "r0"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.23.tar.bz2;name=kernel \
	   ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/v2.6.24/patch-2.6.24-rc6.bz2;patch=1;name=patch \
           file://defconfig \
	   "

S = "${WORKDIR}/linux-2.6.23"

SRC_URI_append_at91sam9260ek = "\
	file://0001-2.6.23-at91.patch;patch=1 \
	"
CMDLINE_at91sam9260ek = "mem=64M console=ttyS0,115200 root=/dev/mtdblock0 rw rootfstype=jffs2"

FILES_kernel-image_at91sam9260ek = ""

do_devicetree_image() {
        if test -n "${DEVICETREE}" ; then
            dtc -I dts -O dtb -o ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_BASE_NAME}.dtb ${DEVICETREE}

            cd ${DEPLOY_DIR_IMAGE}
            rm -f ${KERNEL_IMAGE_SYMLINK_NAME}.dtb
            ln -sf ${KERNEL_IMAGE_BASE_NAME}.dtb ${KERNEL_IMAGE_SYMLINK_NAME}.dtb
        fi
}

addtask devicetree_image after do_deploy before do_package

SRC_URI[kernel.md5sum] = "2cc2fd4d521dc5d7cfce0d8a9d1b3472"
SRC_URI[kernel.sha256sum] = "d4e67c0935ffb2a4158234bff92cc791b83177866009fc9b2214104e0038dbdb"
SRC_URI[patch.md5sum] = "d3f31d6564386938e18e8f74646de9da"
SRC_URI[patch.sha256sum] = "95880162dd0839d9b509152e34cf9356b051dff7daf2216ff50474efbe68f6c3"
