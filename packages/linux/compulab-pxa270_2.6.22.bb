SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Compulab PXA270 system"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-2.6.22.tar.bz2 \
	file://0001-cm-x270-base2.patch;patch=1 \
	file://0002-cm-x270-match-type.patch;patch=1 \
	file://0003-cm-x270-ide.patch;patch=1 \
	file://0004-cm-x270-it8152.patch;patch=1 \
	file://0005-cm-x270-pcmcia.patch;patch=1 \
	file://0006-ramdisk_load.patch;patch=1 \
	file://0007-mmcsd_large_cards-r0.patch;patch=1 \
	file://0008-cm-x270-nand-simplify-name.patch;patch=1 \
        file://defconfig \
	"

#	file://0009-cursor-fix.patch

# Note, for 2.6.22, we are no longer using the compulab binary
# flash driver -- use JFFS2 instead
# see notes in conf/machine/compulab-pxa270.conf

S = "${WORKDIR}/linux-2.6.22"

COMPATIBLE_HOST = 'arm.*-linux'

inherit kernel
inherit package

ARCH = "arm"
KERNEL_IMAGETYPE = "zImage"

FILES_kernel-image = ""

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}

do_deploy() {
	KNAME=${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}.bin
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${KNAME}
}

python do_compulab_image() {
	import os
	import os.path
	import struct

	deploy_dir = bb.data.getVar('DEPLOY_DIR_IMAGE', d, 1)
	kernel_name = os.path.join(deploy_dir, bb.data.expand('${KERNEL_IMAGETYPE}-${MACHINE}.bin', d))

	img_file = os.path.join(deploy_dir, 'zImage-compulab-pxa270.cmx270')

	fo = open(img_file, 'wb')

	image_data = open(kernel_name, 'rb').read()

	# first write size into first 4 bytes
	size_s = struct.pack('i', len(image_data))

	# truncate size if we are running on a 64-bit host
	size_s = size_s[:4]

	fo.write(size_s)
	fo.write(image_data)
	fo.close()
}

do_deploy[dirs] = "${S}"

addtask deploy before do_install after do_compile
addtask compulab_image before do_install after do_deploy

COMPATIBLE_MACHINE = "compulab-pxa270"

