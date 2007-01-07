DESCRIPTION = "U-boot bootloader"
PROVIDES = "virtual/bootloader"
SECTION = "bootloader"
PRIORITY = "optional"
LICENSE = "GPL"

PR = "r1"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-1.1.6.tar.bz2 \
           file://devkit-idp.patch;patch=1"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"

UBOOT_MACHINE ?= "${MACHINE}_config"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.bin"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_compile () {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS
	oe_runmake ${UBOOT_MACHINE}
	oe_runmake all
}

do_stage() {
	install -m755 tools/mkimage ${STAGING_BINDIR_NATIVE}
}

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/u-boot.bin ${DEPLOY_DIR_IMAGE}/${UBOOT_IMAGE}
}
do_deploy[dirs] = "${S}"
addtask deploy before do_build after do_compile
