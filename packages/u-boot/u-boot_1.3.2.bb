require u-boot.inc

DEFAULT_PREFERENCE = "-1"

PR = "r6"

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
           file://001-081209-SPI.patch;patch=1 \
           file://002-081204-GPIO.patch;patch=1 \
           file://003-081205-DTT_LM73.patch;patch=1 \
           file://004-081205-WATCHDOG.patch;patch=1 \
           file://006-081205-EEPROM_INTERSIL.patch;patch=1 \
           file://007-081205-CAPSENSE.patch;patch=1 \
           file://008-081205-TSEC.patch;patch=1 \
           file://009-081205-EXIO.patch;patch=1 \
           file://010-081205-LCD.patch;patch=1 \
           "

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_deploy_append_mpc8313e-rdb () {
	install ${S}/examples/vsc7385_load/vsc7385_load.bin ${DEPLOY_DIR_IMAGE}/vsc7385_load.bin
	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/vsc7385_load.bin
}

