require u-boot.inc

DEFAULT_PREFERENCE = "-1"

PR = "r11"

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
           file://001-090205-SPI.patch;patch=1 \
           file://002-081212-GPIO.patch;patch=1 \
           file://003-081205-DTT_LM73.patch;patch=1 \
           file://004-081205-WATCHDOG.patch;patch=1 \
           file://006-081211-EEPROM_M24C32.patch;patch=1 \
           file://007-090217-CAPSENSE.patch;patch=1 \
           file://008-090107-TSEC.patch;patch=1 \
           file://009-081212-EXIO.patch;patch=1 \
           file://010-081212-LCD.patch;patch=1 \
           file://011-081211-CMD_TEST.patch;patch=1 \
           file://012-081209-BUG_SETENV.patch;patch=1 \
           file://013-090206-FIX_OOB_8BITS_LARGEPAGE_NAND.patch;patch=1 \
           file://014-081211-BOOT_RESCUE.patch;patch=1 \
           file://015-090205-EMC.patch;patch=1 \
           file://016-090209-PM.patch;patch=1 \
           "


do_deploy_append_mpc8313e-rdb () {
	install ${S}/examples/vsc7385_load/vsc7385_load.bin ${DEPLOY_DIR_IMAGE}/vsc7385_load.bin
	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/vsc7385_load.bin
}


SRC_URI[md5sum] = "78b1c2722d3907b5fae2cd219dbaf927"
SRC_URI[sha256sum] = "8ab07cd758a1775642629e624f70e376fa8e84a2f879dee4544158d9c90cde2a"
