DESCRIPTION = "U-boot bootloader OS env. access tools for PPC"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "mtd-utils"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/u-boot-${PV}.tar.bz2 \
	 file://fw_env.h.patch;patch=1 \
	 file://fw_env.c.patch;patch=1 \
	 file://tools-Makefile.patch;patch=1 \
	 file://env-Makefile.patch;patch=1 "

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

do_install () {
	install -d     ${D}/sbin
	install -m 755 ${S}/tools/env/fw_printenv ${D}/sbin/fw_printenv
	install -m 755 ${S}/tools/env/fw_printenv ${D}/sbin/fw_setenv
}
