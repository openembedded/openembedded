require linux.inc

SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Compulab PXA270 system"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
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

S = "${WORKDIR}/linux-${PV}"

COMPATIBLE_HOST = 'arm.*-linux'
COMPATIBLE_MACHINE = "cm-x270"

CMDLINE = "console=${CMX270_CONSOLE_SERIAL_PORT},38400 monitor=8 bpp=16 mem=64M mtdparts=physmap-flash.0:256k(boot)ro,0x180000(kernel),-(root);cm-x270-nand:64m(app),-(data) rdinit=/sbin/init root=mtd3 rootfstype=jffs2"

inherit kernel
inherit package

ARCH = "arm"

FILES_kernel-image = ""

python do_compulab_image() {
	import os
	import os.path
	import struct

	deploy_dir = bb.data.getVar('DEPLOY_DIR_IMAGE', d, 1)
	kernel_file = os.path.join(deploy_dir, bb.data.expand('${KERNEL_IMAGE_BASE_NAME}', d) + '.bin')
	img_file = os.path.join(deploy_dir, bb.data.expand('${KERNEL_IMAGE_BASE_NAME}', d) + '.cmx270')

	fo = open(img_file, 'wb')

	image_data = open(kernel_file, 'rb').read()

	# first write size into first 4 bytes
	size_s = struct.pack('i', len(image_data))

	# truncate size if we are running on a 64-bit host
	size_s = size_s[:4]

	fo.write(size_s)
	fo.write(image_data)
	fo.close()
}

addtask compulab_image after do_deploy before do_package

