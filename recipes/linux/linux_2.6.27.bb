require linux.inc

PR = "r13"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_boc01 = "1"
DEFAULT_PREFERENCE_progear = "1"
DEFAULT_PREFERENCE_simpad = "-1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.45.bz2;patch=1 \
           file://defconfig "

SRC_URI_append_boc01 = "\
	file://boc01.dts \
	file://001-090114-sqn11x0-usb-hack.patch;patch=1 \
	file://004-081205-usb.patch;patch=1 \
	file://005-090226-isl12024.patch;patch=1 \
	file://007-081217-lm73.patch;patch=1 \
	file://008-081208-spi.patch;patch=1 \
	file://011-090115-gpio.patch;patch=1 \
	file://012-090219-capsense.patch;patch=1 \
	file://013-090306-lcd.patch;patch=1 \
	"

SRC_URI_append_progear = "file://progear-bl.patch;patch=1\
                          file://progear-ac2.patch;patch=1"

SRC_URI_append_simpad = "\
           file://linux-2.6.27-SIMpad-GPIO-MMC-mod.patch;patch=1 \
           file://linux-2.6.27-SIMpad-battery-old-way-but-also-with-sysfs.patch;patch=1 \
           file://linux-2.6.27-SIMpad-cs3-simpad.patch;patch=1 \
           file://linux-2.6.27-SIMpad-mq200.patch;patch=1 \
           file://linux-2.6.27-SIMpad-pcmcia.patch;patch=1 \
           file://linux-2.6.27-SIMpad-serial-gpio_keys-and-cs3-ro.patch.v2;patch=1 \
           file://linux-2.6.27-SIMpad-ucb1x00-switches.patch;patch=1 \
           file://linux-2.6.27-SIMpad-ucb1x00-ts-supend-and-accuracy.patch;patch=1 \
           file://linux-2.6.24-SIMpad-hostap_cs-shared-irq.patch;patch=1 \
           file://linux-2.6.24-SIMpad-orinoco_cs-shared-irq.patch;patch=1 \
           file://linux-2.6.24-SIMpad-rtc-sa1100.patch;patch=1 \
           file://connectplus-remove-ide-HACK.patch;patch=1 \
           "

# see http://bugzilla.kernel.org/show_bug.cgi?id=11143
do_stage_append() {
	if [ -f arch/${ARCH}/lib/crtsavres.o ]; then
		mkdir -p ${STAGING_KERNEL_DIR}/arch/${ARCH}/lib
		cp -a arch/${ARCH}/lib/crtsavres.o ${STAGING_KERNEL_DIR}/arch/${ARCH}/lib/
	fi
}

