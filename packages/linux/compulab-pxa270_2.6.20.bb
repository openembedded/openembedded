require linux.inc

SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Compulab PXA270 system"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-2.6.20.tar.bz2 \
	file://0001-gitignore.patch;patch=1 \
	file://0002-cm-x270-base.patch;patch=1 \
	file://0003-ramdisk_load.patch;patch=1 \
	file://0004-nand-driver.patch;patch=1 \
	file://0005-mmcsd_large_cards-r0.patch;patch=1 \
	file://0006-mmcsd_no_scr_check-r0.patch;patch=1 \
        file://defconfig \
	"

# Note, for 2.6.20, we are no longer using the compulab binary
# flash driver -- use JFFS2 instead


S = "${WORKDIR}/linux-2.6.20"

COMPATIBLE_HOST = 'arm.*-linux'

inherit kernel
inherit package

ARCH = "arm"
KERNEL_IMAGETYPE = "zImage"

FILES_kernel-image = ""

do_deploy_append() {
	KNAME=${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}.bin
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${KNAME}
	# Create an image file that has the size prepended (used by cm-x270 BL)
	# The following can only be done on a little endian machine
	# note, the following does not work on all machines as it requires a 
	# recent version of coreutils (>= 6.0).  The correct solution is to code
	# the following in Python instead
	#size=$(stat --printf=%s ${KNAME})
	#size_=$(printf '\%03o'\
	#$((size & 0x000000FF))\
	#$((size>>8 & 0x000000FF))\
	#$((size>>16 & 0x000000FF))\
	#$((size>>24 & 0x000000FF)))
	#size_=${size_}'\c'
	#echo -e $size_ > ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}-${DATETIME}.img
	#cat ${KNAME} >> ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}-${DATETIME}.img
}

COMPATIBLE_MACHINE = "compulab-pxa270"

