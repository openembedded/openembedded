require u-boot.inc

DEFAULT_PREFERENCE = "-1"

PR = "r5"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2"

SRC_URI_append_mpc8313e-rdb = "\
           file://mpc8313e-rdb-autoboot.patch;patch=1 \
           file://mpc8313e-rdb-nand.patch;patch=1 \
           file://mpc8313e-rdb-mtdparts.patch;patch=1 \
           file://mpc8313e-rdb-eeprom.patch;patch=1 \
           file://mpc8313e-rdb-lm75.patch;patch=1 \
           file://u-boot-fsl-1.3.0-mpc8313erdb-vsc7385-support.patch;patch=1 \
           file://u-boot-fsl-1.3.0-mpc8313erdb-fix-vitesse-7385-firmware.patch;patch=1 \
           file://u-boot-fsl-1.3.0-mpc8313erdb-performance-tuning-for-TSEC.patch;patch=1 \
           "

SRC_URI_append_boc01 = "\
           file://mpc8313e-rdb-autoboot.patch;patch=1 \
           file://mpc8313e-rdb-nand.patch;patch=1 \
           file://mpc8313e-rdb-mtdparts.patch;patch=1 \
           file://mpc8313e-rdb-eeprom.patch;patch=1 \
           file://000_01_u-boot-1.3.2_LM73.patch;patch=1 \
           file://001_01_u-boot-1.3.2_SPI.patch;patch=1 \
           file://002_02_u-boot-1.3.2_GPIO.patch;patch=1 \
           file://004_01_u-boot-1.3.2_WATCHDOG.patch;patch=1 \
           file://006_01_u-boot-1.3.2_EEPROM_INTERSIL.patch;patch=1 \
           file://007_01_u-boot-1.3.2_CAPSENSE.patch;patch=1 \
           file://008_02_u-boot-1.3.2_TSEC.patch;patch=1 \
           file://009_03_u-boot-1.3.2_Extender_IO.patch;patch=1 \
           file://010_04_u-boot-1.3.2_LCD.patch;patch=1 \
           "

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_deploy_append_mpc8313e-rdb () {
	install ${S}/examples/vsc7385_load/vsc7385_load.bin ${DEPLOY_DIR_IMAGE}/vsc7385_load.bin
	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/vsc7385_load.bin
}

