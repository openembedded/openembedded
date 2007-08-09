DESCRIPTION = "U-boot bootloader OS env. access tools for PPC"
SECTION = "bootloaders"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "mtd-utils"
PR = "r5"

SRC_URI = "${SOURCEFORGE_MIRROR}/u-boot/u-boot-${PV}.tar.bz2 \
	 file://fw_env.c.patch;patch=1 \
	 file://tools-Makefile.patch;patch=1 \
	 file://env-Makefile.patch;patch=1 \
	 file://fw_env.config"

S = "${WORKDIR}/u-boot-${PV}"
EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"
TARGET_LDFLAGS = ""

UBOOT_MACHINE ?= "${MACHINE}_config"

inherit base

do_configure() {
	:
}

do_compile () {
	oe_runmake Sandpoint8240_config
	oe_runmake tools
}

# install mkimage for the kernel makefile
do_stage() {
	install -d ${STAGING_BINDIR_NATIVE}
	install -m 755 ${S}/tools/mkimage ${STAGING_BINDIR_NATIVE}/
}

do_install () {
	install -d	${D}/sbin
	install -d	${D}${sysconfdir}
	install -m 644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
	install -m 755 ${S}/tools/env/fw_printenv ${D}/sbin/fw_printenv
	install -m 755 ${S}/tools/env/fw_printenv ${D}/sbin/fw_setenv
}
