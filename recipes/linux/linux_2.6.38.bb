require linux.inc

PR = "r4"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

DEFAULT_PREFERENCE_akita = "1"
DEFAULT_PREFERENCE_c7x0 = "1"
DEFAULT_PREFERENCE_collie = "1"
DEFAULT_PREFERENCE_poodle = "1"
DEFAULT_PREFERENCE_spitz = "1"
DEFAULT_PREFERENCE_tosa = "1"
DEFAULT_PREFERENCE_ts72xx = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.5.bz2;apply=yes;name=stablepatch \
           file://defconfig "

SRC_URI_append_akita = " file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 "
SRC_URI_append_c7x0 = " file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 "
SRC_URI_append_collie = " file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 "
SRC_URI_append_poodle = " file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 "
SRC_URI_append_tosa = " file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 "
SRC_URI_append_spitz = " file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 "

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
           file://0020-ts72xx-add-lcd-linux-driver.patch \
           file://0021-TS-72XX-LCD-console-driver.patch \
           file://0024-ARM-ep93xx-Fix-inverted-RTS-and-DTR-signals.patch \
           "

SRC_URI[kernel.md5sum] = "7d471477bfa67546f902da62227fa976"
SRC_URI[kernel.sha256sum] = "72f0cfaefb8dc86b219d5a742dd0375332627641ecbdf5badd3158e2127b9304"
SRC_URI[stablepatch.md5sum] = "c8f233d1d31030eb019ab391071e65c2"
SRC_URI[stablepatch.sha256sum] = "46213fd83da87a066f4b6462c043149638bcaca423d6a932d8434e9d27c7140b"
