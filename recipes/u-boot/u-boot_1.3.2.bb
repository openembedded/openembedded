require u-boot.inc

DEFAULT_PREFERENCE = "-1"

PR = "r12"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2"

SRC_URI_append_mpc8313e-rdb = "\
           file://mpc8313e-rdb-autoboot.patch;apply=yes \
           file://mpc8313e-rdb-nand.patch;apply=yes \
           file://mpc8313e-rdb-mtdparts.patch;apply=yes \
           file://mpc8313e-rdb-eeprom.patch;apply=yes \
           file://mpc8313e-rdb-lm75.patch;apply=yes \
           file://u-boot-fsl-1.3.0-mpc8313erdb-vsc7385-support.patch;apply=yes \
           file://u-boot-fsl-1.3.0-mpc8313erdb-fix-vitesse-7385-firmware.patch;apply=yes \
           file://u-boot-fsl-1.3.0-mpc8313erdb-performance-tuning-for-TSEC.patch;apply=yes \
           file://gcc4-weak-inline.patch;apply=yes \
           file://linker-script-sort-rodata-sections.patch;apply=yes \
           "

SRC_URI_append_boc01 = "\
           file://mpc8313e-rdb-autoboot.patch;apply=yes \
           file://mpc8313e-rdb-nand.patch;apply=yes \
           file://mpc8313e-rdb-mtdparts.patch;apply=yes \
           file://mpc8313e-rdb-eeprom.patch;apply=yes \
           file://001-090205-SPI.patch;apply=yes \
           file://002-081212-GPIO.patch;apply=yes \
           file://003-081205-DTT_LM73.patch;apply=yes \
           file://004-081205-WATCHDOG.patch;apply=yes \
           file://006-081211-EEPROM_M24C32.patch;apply=yes \
           file://007-090217-CAPSENSE.patch;apply=yes \
           file://008-090107-TSEC.patch;apply=yes \
           file://009-081212-EXIO.patch;apply=yes \
           file://010-081212-LCD.patch;apply=yes \
           file://011-081211-CMD_TEST.patch;apply=yes \
           file://012-081209-BUG_SETENV.patch;apply=yes \
           file://013-090206-FIX_OOB_8BITS_LARGEPAGE_NAND.patch;apply=yes \
           file://014-081211-BOOT_RESCUE.patch;apply=yes \
           file://015-090205-EMC.patch;apply=yes \
           file://016-090209-PM.patch;apply=yes \
           "


do_deploy_append_mpc8313e-rdb () {
	install ${S}/examples/vsc7385_load/vsc7385_load.bin ${DEPLOY_DIR_IMAGE}/vsc7385_load.bin
	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/vsc7385_load.bin
}


SRC_URI[md5sum] = "78b1c2722d3907b5fae2cd219dbaf927"
SRC_URI[sha256sum] = "8ab07cd758a1775642629e624f70e376fa8e84a2f879dee4544158d9c90cde2a"
