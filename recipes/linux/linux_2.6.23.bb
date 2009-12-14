require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mpc8313e-rdb = "1"
DEFAULT_PREFERENCE_mpc8323e-rdb = "1"
DEFAULT_PREFERENCE_avr32 = "1"

PR = "r13"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.23.tar.bz2 \
	   file://binutils-buildid-arm.patch;patch=1 \
           file://kallsyms-missing-include.patch;patch=1 \
           file://defconfig \
	   "

# Bug fixes on the 2.6.23.x stable branch
SRC_URI += "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-2.6.23.17.bz2;patch=1"
# Real-time preemption (includes CFS). This is experimental and requires a different defconfig.
#SRC_URI += "file://patch-2.6.23.12-rt14;patch=1"
# Only the Completely Fair Scheduler (CFS), the official backport from 2.6.24 (adapted for 2.6.23.17)
SRC_URI += "file://sched-cfs-v2.6.23.12-v24.1.patch;patch=1"
# Add support for squashfs-lzma (a highly compressed read-only filesystem)
SRC_URI += "http://kamikaze.waninkoko.info/patches/2.6.23/klight1/broken-out/squashfs-lzma-2.6.23.patch;patch=1"

SRC_URI += "file://time.h.patch;patch=1"

# The Atmel patch doesn't apply against 2.6.23.12  :( 
SRC_URI_avr32 = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.23.tar.bz2 \
                 file://defconfig \
                 http://avr32linux.org/twiki/pub/Main/LinuxPatches/linux-2.6.23.atmel.3.patch.bz2;patch=1 \
                "
SRC_URI_append_em-x270 = "\
	file://em-x270.patch;patch=1 "

SRC_URI_append_cm-x270 = "\
	file://0001-cm-x270-base2.patch;patch=1 \
	file://0002-cm-x270-match-type.patch;patch=1 \
	file://0003-cm-x270-ide.patch;patch=1 \
	file://0004-cm-x270-it8152.patch;patch=1 \
	file://0005-cm-x270-pcmcia.patch;patch=1 \
	file://0006-ramdisk_load.patch;patch=1 \
	file://0007-mmcsd_large_cards-r0.patch;patch=1 \
	file://0008-cm-x270-nand-simplify-name.patch;patch=1"

SRC_URI_append_mpc8313e-rdb = "\
	file://mpc831x-nand.patch;patch=1 \
	file://mpc8313e-rdb-leds.patch;patch=1 \
	file://mpc8313e-rdb-rtc.patch;patch=1"

SRC_URI_append_mpc8323e-rdb = "\
	file://mpc832x-leds.patch;patch=1" 

CMDLINE_cm-x270 = "console=${CMX270_CONSOLE_SERIAL_PORT},38400 monitor=8 bpp=16 mem=64M mtdparts=physmap-flash.0:256k(boot)ro,0x180000(kernel),-(root);cm-x270-nand:64m(app),-(data) rdinit=/sbin/init root=mtd3 rootfstype=jffs2"

FILES_kernel-image_cm-x270 = ""

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


addtask compulab_image after do_package before do_build

