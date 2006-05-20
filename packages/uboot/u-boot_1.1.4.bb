DESCRIPTION = "U-boot bootloader"
PROVIDES = "virtual/bootloader"
SECTION = "bootloader"
MAINTAINER = "Holger Schurig"
PRIORITY = "optional"
LICENSE = "GPL"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2"
SRC_URI_append_gumstix = "\
						  file://u-boot-autoscript.patch;patch=1 \
						  file://u-boot-base.patch;patch=1 \
						  file://u-boot-crc-warning-not-so-scary.patch;patch=1 \
						  file://u-boot-flash-protect-fixup.patch;patch=1 \
						  file://u-boot-fw_printenv.patch;patch=1 \
						  file://u-boot-install.patch;patch=1 \
						  file://u-boot-jerase-cmd.patch;patch=1 \
						  file://u-boot-jffs2-new-nodetypes.patch;patch=1 \
						  file://u-boot-loadb-safe.patch;patch=1 \
						  file://u-boot-mmc-init.patch;patch=1 \
						  file://u-boot-mmcclk-alternate.patch;patch=1 \
						  file://u-boot-smc91x-multi.patch;patch=1 \
						  file://u-boot-zzz-osx.patch;patch=1"
SRC_URI_append_amsdelta = "\
	http://the.earth.li/pub/e3/u-boot-amsdelta-20060519.diff;patch=1"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"
EXTRA_OEMAKE_gumstix = "CROSS_COMPILE=${TARGET_PREFIX} GUMSTIX_400MHZ=${GUMSTIX_400MHZ}"
TARGET_LDFLAGS = ""

UBOOT_MACHINE ?= "${MACHINE}_config"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.bin"

def gumstix_mhz(d):
	import bb
        m = bb.data.getVar('GUMSTIX_400MHZ', d, 1)
	if 'y' == m:
		return '400'
	else:
		return '200'

UBOOT_IMAGE_gumstix = "u-boot-${MACHINE}-${@gumstix_mhz(d)}Mhz-${PV}-${PR}.bin"

inherit base

do_compile () {
	oe_runmake ${UBOOT_MACHINE}
	oe_runmake all
}

do_stage() {
	install -m755 tools/mkimage ${STAGING_BINDIR}
}

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/u-boot.bin ${DEPLOY_DIR_IMAGE}/${UBOOT_IMAGE}
}
do_deploy[dirs] = "${S}"
addtask deploy before do_build after do_compile
