require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_gesbc-9302 = "1"
DEFAULT_PREFERENCE_cm-x270 = "1"
DEFAULT_PREFERENCE_mpc8313e-rdb = "1"
DEFAULT_PREFERENCE_simpad = "1"

DEPENDS_append_mpc8313e-rdb = " dtc-native"

PR = "r9"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.24.tar.bz2 \
           http://kamikaze.waninkoko.info/patches/2.6.24/kamikaze1/broken-out/squashfs-lzma-2.6.24.patch;patch=1 \
#           file://powerpc-clockres.patch;patch=1 \
#           file://leds-cpu-activity.patch;patch=1 \
#           file://leds-cpu-activity-powerpc.patch;patch=1 \
           file://defconfig"

# Real-time preemption. This is experimental and requires a different defconfig.
#SRC_URI += " http://www.kernel.org/pub/linux/kernel/projects/rt/patch-2.6.24-rt1.bz2;patch=1"

SRC_URI_append_simpad = "\
           file://linux-2.6.24-SIMpad-GPIO-MMC-mod.patch;patch=1 \
           file://linux-2.6.24-SIMpad-battery-old-way-but-also-with-sysfs.patch;patch=1 \
           file://linux-2.6.24-SIMpad-cs3-simpad.patch;patch=1 \
           file://linux-2.6.24-SIMpad-mq200.patch;patch=1 \
           file://linux-2.6.24-SIMpad-pcmcia.patch;patch=1 \
           file://linux-2.6.24-SIMpad-serial-gpio_keys-and-cs3-ro.patch;patch=1 \
           file://linux-2.6.24-SIMpad-ucb1x00-switches.patch;patch=1 \
           file://linux-2.6.24-SIMpad-ucb1x00-ts-supend-and-accuracy.patch;patch=1 \
           file://linux-2.6.24-SIMpad-hostap_cs-shared-irq.patch;patch=1 \
           file://linux-2.6.24-SIMpad-orinoco_cs-shared-irq.patch;patch=1 \ 
           file://linux-2.6.24-SIMpad-rtc-sa1100.patch;patch=1 \
	   file://collie-kexec.patch;patch=1 \
           file://export_atags-r2.patch;patch=1 \
           "	   

SRC_URI_append_gesbc-9302 = " \
	file://0001-gesbc-nand.patch;patch=1 \
	file://0002-gesbc-eth-platform.patch;patch=1 \
	file://0005-ep93xx-reboot.patch;patch=1 \
	"

SRC_URI_append_mpc8313e-rdb = "\
	file://mpc831x-nand.patch;patch=1 \
	file://mpc8313e-rdb-leds.patch;patch=1 \
	file://mpc8313e-rdb-rtc.patch;patch=1"

CMDLINE_gesbc-9302 = "console=ttyAM0 root=mtd5 rootfstype=jffs2 mtdparts=GESBC-NAND:64m(app),-(data)"

SRC_URI_append_cm-x270 = " \
	file://0001-cm-x270-match-type.patch;patch=1 \
	file://0002-ramdisk_load.patch;patch=1 \
	file://0003-mmcsd_large_cards-r0.patch;patch=1 \
	file://0004-cm-x270-nand-simplify-name.patch;patch=1 \
	file://0005-add-display-set-default-16bpp.patch;patch=1 \
	"

CMDLINE_cm-x270 = "console=${CMX270_CONSOLE_SERIAL_PORT},38400 monitor=1 mem=64M mtdparts=physmap-flash.0:256k(boot)ro,0x180000(kernel),-(root);cm-x270-nand:64m(app),-(data) rdinit=/sbin/init root=mtd3 rootfstype=jffs2"

FILES_kernel-image_gesbc-9302 = ""

DEVICETREE_mpc8313e-rdb = "arch/${ARCH}/boot/dts/mpc8313erdb.dts"
DEVICETREE_FLAGS_mpc8313e-rdb = "-R 8 -S 0x3000"
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


do_devicetree_image() {
        if test -n "${DEVICETREE}" ; then
            dtc -I dts -O dtb ${DEVICETREE_FLAGS} -o ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_BASE_NAME}.dtb ${DEVICETREE}

            cd ${DEPLOY_DIR_IMAGE}
            rm -f ${KERNEL_IMAGE_SYMLINK_NAME}.dtb
            ln -sf ${KERNEL_IMAGE_BASE_NAME}.dtb ${KERNEL_IMAGE_SYMLINK_NAME}.dtb
        fi
}

addtask compulab_image after do_deploy before do_package
addtask devicetree_image after do_deploy before do_package

