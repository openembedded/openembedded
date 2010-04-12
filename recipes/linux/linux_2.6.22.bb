require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_cm-x270 = "-1"
DEFAULT_PREFERENCE_bd-neon = "0"
DEFAULT_PREFERENCE_mx31moboard = "1"

PR = "r6"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.22.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.19.bz2;patch=1;name=stablepatch \
           file://defconfig \
	   "

SRC_URI_append_cm-x270 = "\
	file://0001-cm-x270-base2.patch;patch=1 \
	file://0002-cm-x270-match-type.patch;patch=1 \
	file://0003-cm-x270-ide.patch;patch=1 \
	file://0004-cm-x270-it8152.patch;patch=1 \
	file://0005-cm-x270-pcmcia.patch;patch=1 \
	file://0006-ramdisk_load.patch;patch=1 \
	file://0007-mmcsd_large_cards-r0.patch;patch=1 \
	file://0008-cm-x270-nand-simplify-name.patch;patch=1"

SRC_URI_append_mx31moboard = "http://mobots.epfl.ch/mx31moboard/linux-2.6.22-moboard.patch.bz2;patch=1;name=mx31patch"

CMDLINE_cm-x270 = "console=${CMX270_CONSOLE_SERIAL_PORT},38400 monitor=8 bpp=16 mem=64M mtdparts=physmap-flash.0:256k(boot)ro,0x180000(kernel),-(root);cm-x270-nand:64m(app),-(data) rdinit=/sbin/init root=mtd3 rootfstype=jffs2"

FILES_kernel-image_cm-x270 = ""

SRC_URI_append_bd-neon =  " http://www.boundarydevices.com/boundary-2.6.22-2007-07-22.patch.bz2;patch=1;name=neonpatch"

python do_compulab_image() {
	import os
	import os.path
	import struct

	machine = bb.data.getVar('MACHINE', d, 1)
	if machine == "cm-x270":
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

	    os.chdir(deploy_dir)
	    link_file = bb.data.expand('${KERNEL_IMAGE_SYMLINK_NAME}', d) + '.cmx270'
	    img_file = bb.data.expand('${KERNEL_IMAGE_BASE_NAME}', d) + '.cmx270'
	    try:
		os.unlink(link_file)
	    except:
		pass
	    os.symlink(img_file, link_file)
}

addtask compulab_image after do_deploy before do_build

SRC_URI[kernel.md5sum] = "2e230d005c002fb3d38a3ca07c0200d0"
SRC_URI[kernel.sha256sum] = "73c10604c53f1a6ee65ef805293d23903696f8cef864f42d7de9506f0d2ba4c7"
SRC_URI[stablepatch.md5sum] = "066cc3bdd2783dcd01f6ff466e449ec0"
SRC_URI[stablepatch.sha256sum] = "829c48b49c71d89468f2a5a05587714811197545eeba31e9643cabacf344d33a"

SRC_URI[neonpatch.md5sum] = "7dac7a5cf401070ecccf42666a30fc0a"
SRC_URI[neonpatch.sha256sum] = "da8a360035464defd133a4ba604aa7ae9ee077747511b98384862b4cbdde5906"
