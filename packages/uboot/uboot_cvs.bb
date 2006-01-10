DESCRIPTION = "U-boot bootloader"
SECTION = "bootloader"
MAINTAINER = "Cliff Brake <cliff.brake@gmail.com>"
PRIORITY = "optional"
LICENSE = "GPL"
PV = "0.0+cvs${SRCDATE}"
PR = "r2"

PROVIDES = "virtual/bootloader"

S = "${WORKDIR}/u-boot"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/u-boot;module=u-boot \
	   file://arm_flags.patch;patch=1"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"
TARGET_LDFLAGS = ""
UBOOT_MACHINE ?= "${MACHINE}"

inherit base

do_compile () {
	oe_runmake ${UBOOT_MACHINE}
	oe_runmake all
}

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/u-boot.bin ${DEPLOY_DIR_IMAGE}/u-boot-${MACHINE}-${DATETIME}.bin
}
do_deploy[dirs] = "${S}"
addtask deploy before do_build after do_compile
