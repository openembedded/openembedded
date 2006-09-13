DESCRIPTION = "U-boot bootloader"
PROVIDES = "virtual/bootloader"
SECTION = "bootloader"
MAINTAINER = "philip@balister.org"
PRIORITY = "optional"
LICENSE = "GPL"

PR = "r0"

TAG = "${@bb.data.getVar('PV',d,1).replace('.', '_')}"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git;tag=${TAG}"
#           file://config.patch;patch=1"

S = "${WORKDIR}/git"

#EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX} CFLAGS="" CPPFLAGS="" LDFLAGS="""
EXTRA_OEMAKE = ""

UBOOT_MACHINE ?= "${MACHINE}_config"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.bin"


#inherit base

do_compile () {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS
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
