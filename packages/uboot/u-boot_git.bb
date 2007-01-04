DESCRIPTION = "U-boot bootloader"
PROVIDES = "virtual/bootloader"
SECTION = "bootloader"
PRIORITY = "optional"
LICENSE = "GPL"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git "

S = "${WORKDIR}/git"

#EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX} CFLAGS="" CPPFLAGS="" LDFLAGS="""
EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"

UBOOT_MACHINE ?= "${MACHINE}_config"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.bin"

PACKAGE_ARCH = "${MACHINE_ARCH}"

#inherit base

do_compile () {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS
	oe_runmake ${UBOOT_MACHINE}
	oe_runmake all
}

do_stage() {
	install -m 755 tools/mkimage ${STAGING_BINDIR_NATIVE}
}

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/u-boot.bin ${DEPLOY_DIR_IMAGE}/${UBOOT_IMAGE}
}
do_deploy[dirs] = "${S}"
addtask deploy before do_build after do_compile
