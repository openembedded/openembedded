BROKEN = "1"
#not fetchable patch used

DESCRIPTION = "U-boot bootloader"
SECTION = "bootloader"
PRIORITY = "optional"
LICENSE = "GPL"
SRCDATE = "20050818"
PV = "0.0+cvs${SRCDATE}"
PR = "r3"

PROVIDES = "virtual/bootloader"

S = "${WORKDIR}/u-boot"

SRC_URI = "cvs://anonymous@u-boot.cvs.sourceforge.net/cvsroot/u-boot;module=u-boot \
	   file://arm_flags.patch;patch=1 \
	   ftp://ftp.accelent.com/pxa255_idp/uboot/u-boot-1.1.2-cvs20050818-r2-pxa255idp1.patch;patch=1"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"
TARGET_LDFLAGS = ""
UBOOT_MACHINE = "pxa255_idp_config"

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

