DESCRIPTION = "U-boot bootloader w/ armzone qt2410 support"
SECTION = "bootloader"
PRIORITY = "optional"
LICENSE = "GPL"
SRCDATE := "${PV}"
PR = "r0"

PROVIDES = "virtual/bootloader"
S = "${WORKDIR}/git"

SRC_URI = "git://www.denx.de/git/u-boot.git/;protocol=git \
	   file://u-boot-20061030-qt2410-gta01.patch;patch=1 \
	   file://qt2410_*.h"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"
TARGET_LDFLAGS = ""
UBOOT_MACHINE = "qt2410_config"

inherit base

do_compile () {
	for type in nand  ram
	do
		install -m 0644 ${WORKDIR}/qt2410_${type}.h include/configs/qt2410.h
		oe_runmake ${UBOOT_MACHINE}
		oe_runmake all
		mv u-boot.bin u-boot_$type.bin
	done
}

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	for type in nand ram
	do
		install ${S}/u-boot_$type.bin ${DEPLOY_DIR_IMAGE}/u-boot_$type-${MACHINE}-${DATETIME}.bin
	done
	install -m 0755 tools/mkimage ${STAGING_BINDIR}/uboot-mkimage
}

do_deploy[dirs] = "${S}"
addtask deploy before do_build after do_compile
