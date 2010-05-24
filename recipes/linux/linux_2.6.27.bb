require linux.inc

PR = "r14"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_boc01 = "1"
DEFAULT_PREFERENCE_progear = "1"
DEFAULT_PREFERENCE_simpad = "-1"
DEFAULT_PREFERENCE_ts72xx = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.45.bz2;apply=yes;name=stablepatch \
           file://defconfig "

SRC_URI_append_boc01 = "\
	file://boc01.dts \
	file://001-090114-sqn11x0-usb-hack.patch;apply=yes \
	file://004-081205-usb.patch;apply=yes \
	file://005-090226-isl12024.patch;apply=yes \
	file://007-081217-lm73.patch;apply=yes \
	file://008-081208-spi.patch;apply=yes \
	file://011-090115-gpio.patch;apply=yes \
	file://012-090219-capsense.patch;apply=yes \
	file://013-090306-lcd.patch;apply=yes \
	"

SRC_URI_append_progear = "file://progear-bl.patch;apply=yes\
                          file://progear-ac2.patch;apply=yes"

SRC_URI_append_simpad = "\
           file://linux-2.6.27-SIMpad-GPIO-MMC-mod.patch;apply=yes \
           file://linux-2.6.27-SIMpad-battery-old-way-but-also-with-sysfs.patch;apply=yes \
           file://linux-2.6.27-SIMpad-cs3-simpad.patch;apply=yes \
           file://linux-2.6.27-SIMpad-mq200.patch;apply=yes \
           file://linux-2.6.27-SIMpad-pcmcia.patch;apply=yes \
           file://linux-2.6.27-SIMpad-serial-gpio_keys-and-cs3-ro.patch.v2;apply=yes \
           file://linux-2.6.27-SIMpad-ucb1x00-switches.patch;apply=yes \
           file://linux-2.6.27-SIMpad-ucb1x00-ts-supend-and-accuracy.patch;apply=yes \
           file://linux-2.6.24-SIMpad-hostap_cs-shared-irq.patch;apply=yes \
           file://linux-2.6.24-SIMpad-orinoco_cs-shared-irq.patch;apply=yes \
           file://linux-2.6.24-SIMpad-rtc-sa1100.patch;apply=yes \
           file://connectplus-remove-ide-HACK.patch;apply=yes \
           "

SRC_URI_append_ts72xx = "\
           file://0001-TS72xx-update-memory-map-comments.patch;apply=yes \
           file://0002-GPIO-fix.patch;apply=yes \
           file://0003-Debounce-IRQ.patch;apply=yes \
           file://0004-OHCI-fix.patch;apply=yes \
           file://0005-Fix-wrong-machine-ID-passed-from-RedBoot.patch;apply=yes \
           file://0006-Force-the-nF-bit-on.patch;apply=yes \
           file://0007-Use-CPLD-watchdog-to-reset.patch;apply=yes \
           file://0008-Fix-UART-clocks.patch;apply=yes \
           file://0009-CPU-info-and-board-revision.patch;apply=yes \
           file://0010-GPIO-leds.patch;apply=yes \
           file://0011-EP93xx-Ethernet-support.patch;apply=yes \
           file://0012-TS72xx-watchdog.patch;apply=yes \
           file://0013-TS7200-NOR-physmap-fix.patch;apply=yes \
           file://0014-TS-7200-8MB-NOR-flash.patch;apply=yes \
           file://0015-TS-72xx-MAX197-support.patch;apply=yes \
           file://0016-RS485-common-bits.patch;apply=yes \
           file://0017-TS-72xx-SBC-proc-info.patch;apply=yes \
           file://0018-EP93xx-GPIO-I2C.patch;apply=yes \
           file://0019-EP93xx-SPI-driver.patch;apply=yes \
           file://0020-TS-72XX-LCD-console-driver.patch;apply=yes \
           file://0021-EP93xx-GPIO-matrix-keypad.patch;apply=yes \
           file://0022-TS-72xx-RS485-auto-mode-support.patch;apply=yes \
           file://0023-Clean-and-invalidate-D-cache-entry.patch;apply=yes \
           file://0024-PC-104-I-O-and-memory-mappings.patch;apply=yes \
           file://0025-EP93xx-discontigmem.patch;apply=yes \
           file://0026-TS72xx-PATA-support.patch;apply=yes \
           file://0027-TS72xx-TS-SER1-support.patch;apply=yes \
           file://0028-TS72xx-TS-ETH100.patch;apply=yes \
           file://0029-EP93xx-Power-Management-Routines.patch;apply=yes \
           file://0030-EP93xx-CPUfreq-driver.patch;apply=yes \
           "

# see http://bugzilla.kernel.org/show_bug.cgi?id=11143
do_install_append() {
	if [ -f arch/${ARCH}/lib/crtsavres.o ]; then
		mkdir -p $kerneldir/arch/${ARCH}/lib
		cp -a arch/${ARCH}/lib/crtsavres.o $kerneldir/arch/${ARCH}/lib/
	fi
}


SRC_URI[kernel.md5sum] = "b3e78977aa79d3754cb7f8143d7ddabd"
SRC_URI[kernel.sha256sum] = "0e99bf9e83f4d1ae0c656741a84dfddfa9c4d2469cf35475f5939d02dc3e4393"
SRC_URI[stablepatch.md5sum] = "9ad766753f54ba0a4df7c42873e7aa16"
SRC_URI[stablepatch.sha256sum] = "fb78c95e902194ac62facdbad1a89430c991271a35e4bd30ce9dad2f948d99c8"
