SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Compulab PXA270 system"
LICENSE = "GPL"
PR = "r3"

# Note, the compulab package contains a binary NAND driver that is not
# EABI compatible

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.16.tar.bz2 \
           file://linux-2.6.16.patch;patch=1 \
           file://defconfig \
	   http://www.compulab.co.il/x270/download/x270-linux-drv.zip;md5sum=ac57536294406223e527367af5aefce2"

S = "${WORKDIR}/linux-2.6.16"

COMPATIBLE_HOST = 'arm.*-linux'

inherit kernel
inherit package

ARCH = "arm"
KERNEL_IMAGETYPE = "zImage"

FILES_kernel-image = ""

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	install -m 0644 ${WORKDIR}/2.6.16/CL_FlashDrv ${S}/drivers/block/cl_flash
}

do_deploy() {
	KNAME=${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}.bin
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${KNAME}
	# Create an image file that has the size prepended (used by cm-x270 BL)
	# The following can only be done on a little endian machine
	# the following does not work on all computers as it requires a recent
	# version of coreutils (>= 6.0).  We will eventually replace the following
	# with python code.
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

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile

COMPATIBLE_MACHINE = "compulab-pxa270"

