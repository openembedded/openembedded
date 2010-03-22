require linux.inc

PR = "r14"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_boc01 = "1"
DEFAULT_PREFERENCE_progear = "1"
DEFAULT_PREFERENCE_simpad = "-1"
DEFAULT_PREFERENCE_ts72xx = "1"

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

SRC_URI_append_ts72xx = "\
           file://0001-TS72xx-update-memory-map-comments.patch;patch=1 \
           file://0002-GPIO-fix.patch;patch=1 \
           file://0003-Debounce-IRQ.patch;patch=1 \
           file://0004-OHCI-fix.patch;patch=1 \
           file://0005-Fix-wrong-machine-ID-passed-from-RedBoot.patch;patch=1 \
           file://0006-Force-the-nF-bit-on.patch;patch=1 \
           file://0007-Use-CPLD-watchdog-to-reset.patch;patch=1 \
           file://0008-Fix-UART-clocks.patch;patch=1 \
           file://0009-CPU-info-and-board-revision.patch;patch=1 \
           file://0010-GPIO-leds.patch;patch=1 \
           file://0011-EP93xx-Ethernet-support.patch;patch=1 \
           file://0012-TS72xx-watchdog.patch;patch=1 \
           file://0013-TS7200-NOR-physmap-fix.patch;patch=1 \
           file://0014-TS-7200-8MB-NOR-flash.patch;patch=1 \
           file://0015-TS-72xx-MAX197-support.patch;patch=1 \
           file://0016-RS485-common-bits.patch;patch=1 \
           file://0017-TS-72xx-SBC-proc-info.patch;patch=1 \
           file://0018-EP93xx-GPIO-I2C.patch;patch=1 \
           file://0019-EP93xx-SPI-driver.patch;patch=1 \
           file://0020-TS-72XX-LCD-console-driver.patch;patch=1 \
           file://0021-EP93xx-GPIO-matrix-keypad.patch;patch=1 \
           file://0022-TS-72xx-RS485-auto-mode-support.patch;patch=1 \
           file://0023-Clean-and-invalidate-D-cache-entry.patch;patch=1 \
           file://0024-PC-104-I-O-and-memory-mappings.patch;patch=1 \
           file://0025-EP93xx-discontigmem.patch;patch=1 \
           file://0026-TS72xx-PATA-support.patch;patch=1 \
           file://0027-TS72xx-TS-SER1-support.patch;patch=1 \
           file://0028-TS72xx-TS-ETH100.patch;patch=1 \
           file://0029-EP93xx-Power-Management-Routines.patch;patch=1 \
           file://0030-EP93xx-CPUfreq-driver.patch;patch=1 \
           "

# see http://bugzilla.kernel.org/show_bug.cgi?id=11143
do_stage_append() {
	if [ -f arch/${ARCH}/lib/crtsavres.o ]; then
		mkdir -p ${STAGING_KERNEL_DIR}/arch/${ARCH}/lib
		cp -a arch/${ARCH}/lib/crtsavres.o ${STAGING_KERNEL_DIR}/arch/${ARCH}/lib/
	fi
}

