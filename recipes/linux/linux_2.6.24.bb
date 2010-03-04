require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_gesbc-9302 = "1"
DEFAULT_PREFERENCE_mpc8313e-rdb = "1"
DEFAULT_PREFERENCE_simpad = "1"
DEFAULT_PREFERENCE_atngw100 = "1"
DEFAULT_PREFERENCE_at32stk1000 = "1"
DEFAULT_PREFERENCE_hipox = "1"
DEFAULT_PREFERENCE_cs-e9302 = "1"
DEFAULT_PREFERENCE_smartq5 = "1"

PR = "r34"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.24.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.7.bz2;patch=1 \
           file://squashfs-lzma-2.6.24.patch;patch=1 \
           file://ubifs-v2.6.24.patch;patch=1 \
           file://defconfig"

# Moved away temporarely until committed properly (work in progress).
#           file://powerpc-clockres.patch;patch=1 \
#           file://leds-cpu-activity.patch;patch=1 \
#           file://leds-cpu-activity-powerpc.patch;patch=1 \

SRC_URI_append_simpad = "\
           file://linux-2.6.24-SIMpad-GPIO-MMC-mod.patch;patch=1 \
           file://linux-2.6.24-SIMpad-battery-old-way-but-also-with-sysfs.patch;patch=1 \
           file://linux-2.6.24-SIMpad-cs3-simpad.patch;patch=1 \
           file://linux-2.6.24-SIMpad-mq200.patch;patch=1 \
           file://linux-2.6.24-SIMpad-pcmcia.patch;patch=1 \
           file://linux-2.6.24-SIMpad-serial-gpio_keys-and-cs3-ro.patch.v2;patch=1 \ 
           file://linux-2.6.24-SIMpad-ucb1x00-switches.patch;patch=1 \
           file://linux-2.6.24-SIMpad-ucb1x00-ts-supend-and-accuracy.patch;patch=1 \
           file://linux-2.6.24-SIMpad-hostap_cs-shared-irq.patch;patch=1 \
           file://linux-2.6.24-SIMpad-orinoco_cs-shared-irq.patch;patch=1 \ 
           file://linux-2.6.24-SIMpad-rtc-sa1100.patch;patch=1 \
           file://linux-2.6.24-SIMpad-ucb1x00-audio.patch;patch=1 \
	   file://connectplus-remove-ide-HACK.patch;patch=1 \
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
	file://mpc8313e-rdb-rtc.patch;patch=1 \
	file://mpc8313e-rdb-cardbus.patch;patch=1 \
	"

CMDLINE_gesbc-9302 = "console=ttyAM0 root=mtd5 rootfstype=jffs2 mtdparts=GESBC-NAND:64m(app),-(data)"

SRC_URI_append_cm-x270 = " \
	file://0001-cm-x270-match-type.patch;patch=1 \
	file://0002-ramdisk_load.patch;patch=1 \
	file://0003-mmcsd_large_cards-r0.patch;patch=1 \
	file://0004-cm-x270-nand-simplify-name.patch;patch=1 \
	file://0005-add-display-set-default-16bpp.patch;patch=1 \
	"

SRC_URI_avr32 = "http://avr32linux.org/twiki/pub/Main/LinuxPatches/linux-2.6.24.3.atmel.3.tar.bz2 \
                 file://defconfig"
S_avr32 = "${WORKDIR}/linux-2.6.24.3.atmel.3"

SRC_URI_append_ts72xx = "\
	file://ep93xx-gpio-interrupt-debounce.diff;patch=1 \
	file://ep93xx-i2c-bus.diff;patch=1 \
	file://ep93xx-i2c.diff;patch=1 \
	file://ep93xx-leds.diff;patch=1 \
	file://ep93xx-serial-uartbaud.diff;patch=1 \
	file://ep93xx-serial-clocks.diff;patch=1 \
	file://ep93xx-timer-accuracy.diff;patch=1 \
	file://ep93xx-maverick-uniqid.patch;patch=1 \
	file://ep93xx-eth-phylib-framework.patch;patch=1 \
	file://ts72xx-nfbit-fix.patch;patch=1 \
	file://ts72xx-machine-id-fix.patch;patch=1 \
	file://ts72xx-watchdog.patch;patch=1 \
	file://ts72xx-use-cpld-reset.patch;patch=1 \
	file://ts72xx-rs485.patch;patch=1"

SRC_URI_append_hipox = " \
	file://hipox-mach-type.patch;patch=1 \
	file://hipox.patch;patch=1 \
	file://hipox-uart.patch;patch=1 \
	file://hipox-pci-config-delay.patch;patch=1 \
	file://hipox-pci-max-size.patch;patch=1 \
	file://hipox-nand.patch;patch=1 \
	file://hipox-ubifs.patch;patch=1 \
	file://hipox-kconfig.patch;patch=1 \
	file://hipox-sata-module.patch;patch=1 \
	file://hipox-OXE-INT2.patch;patch=1 \
	file://hipox-rtc.patch;patch=1 \
	file://hipox-nand-vs-pci.patch;patch=1 \
	file://hipox-nand-vs-nor.patch;patch=1 \
	"

EXTRA_OEMAKE_smartq5 = " OBJCOPY=${OBJCOPY}"
SRC_URI_smartq5 = " ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.24.tar.bz2 \
    http://ftp.kernel.org/pub/linux/kernel/v2.6/patch-2.6.24.7.bz2;patch=1 \
    file://smartq-gitupdate.diff;patch=1 \
    file://base/0001-Apply-samsung-kernel-patch.patch;patch=1 \
    file://base/0002-Apply-smartq-patch.patch;patch=1 \
    file://mer/0001-Mer-keymappings-change.patch;patch=1 \
    file://mer/0002-no-DM9000.patch;patch=1 \
    file://mer/0003-Mer-WPA-fix.patch;patch=1 \
    file://mer/0004-Mer-hardwire-USB-OTG-gadget-type.patch;patch=1 \
    file://mer/0005-backlight-parameter-and-fixes.patch;patch=1 \
    file://mer/0006-tv-encoder.patch;patch=1 \
    file://mer/0007-make-tv-encoder-scaler-compile.patch;patch=1 \
    file://mer/0008-build-TV-by-default.patch;patch=1 \
    file://mer/0009-Apply-cpufreq-patch-from-gqwang.patch;patch=1 \
    file://mer/0010-Better-compatibility-with-some-memory-chips.patch;patch=1 \
    file://mer/0011-Only-reserve-memory-for-TV-if-CONFIG_VIDEO_SAMSUNG_T.patch;patch=1 \
    file://mer/0012-Disable-TV-out-to-save-RAM.patch;patch=1 \
    file://defconfig \
"


CMDLINE_cm-x270 = "console=${CMX270_CONSOLE_SERIAL_PORT},38400 monitor=1 mem=64M mtdparts=physmap-flash.0:256k(boot)ro,0x180000(kernel),-(root);cm-x270-nand:64m(app),-(data) rdinit=/sbin/init root=mtd3 rootfstype=jffs2"

FILES_kernel-image_gesbc-9302 = ""

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

