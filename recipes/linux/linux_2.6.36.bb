require linux.inc

PR = "r2"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mx31ads = "1"
DEFAULT_PREFERENCE_ts72xx = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/${P}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.1.bz2;apply=yes;name=stablepatch \
           file://defconfig "

SRC_URI_append_mx31ads = "file://0001-add-missing-include.patch"

SRC_URI_append_ts72xx = " \
	file://0001-ts72xx_base.patch \
	file://0002-ts72xx_force_machine-id.patch \
	file://0003-ep93xx_cpuinfo.patch \
	file://0004-ep93xx_eth.patch \
	file://0005-ep93xx-m2m-DMA-support.patch \
	file://0006-ts72xx_rs485.patch \
	file://0007-ts72xx_ts_ser1.patch \
	file://0008-ts72xx_ts_eth100.patch \
	file://0009-ts72xx_pata.patch \
	file://0010-ts72xx_gpio_i2c.patch \
	file://0011-ts72xx_dio_keypad.patch \
	file://0012-ts72xx_sbcinfo.patch \
	file://0013-ts72xx_max197.patch \
	file://0014-ts7200_nor_flash.patch \
	file://0015-ts72xx_sdcard.patch \
	file://0016-ts72xx_spi_tmp124.patch \
	file://0017-ts72xx-use-CPLD-watchdog-for-reset.patch \
	file://0018-ethoc-ts7300-fixes.patch \
	file://0019-ts7300-add-ethernet-support.patch \
	file://0023-ts72xx-add-lcd-linux-driver.patch \
	file://0024-ts72xx-add-GPIO-keys.patch \
	"

SRC_URI[kernel.md5sum] = "61f3739a73afb6914cb007f37fb09b62"
SRC_URI[kernel.sha256sum] = "15a076d1a435a6bf8e92834eba4b390b4ec094ce06d47f89d071ca9e5788ce04"
SRC_URI[stablepatch.md5sum] = "dd38a6caf08df2822f93541ee95aed7d"
SRC_URI[stablepatch.sha256sum] = "0312883792d9b6312684800c7e9c108571a0da39fbb0a4fb9beb1362b7446c98"
