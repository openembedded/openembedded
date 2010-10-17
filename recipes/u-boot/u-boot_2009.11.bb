PR = "r1"
require u-boot.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_at91sam9g10ek = "2"
DEFAULT_PREFERENCE_at91sam9g20ek = "2"
DEFAULT_PREFERENCE_at91sam9g45ek = "2"
DEFAULT_PREFERENCE_at91sam9m10ekes = "2"
DEFAULT_PREFERENCE_at91sam9m10g45ek = "2"
DEFAULT_PREFERENCE_at91sam9g45ek = "2"
DEFAULT_PREFERENCE_at91sam9g45ekes = "2"


SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 "

SRC_URI_append_at91 = "\
	file://at91/0002-Support-running-ATSAM9G45-M10-from-dataflash.patch;patch=1 \
	file://at91/0003-Update-SAM9M10-G45-config-for-dataflash-support.patch;patch=1 \
	file://at91/0004-Support-selecting-SPI-mode-in-dataflash-driver.patch;patch=1 \
	file://at91/0005-mux-replace-verbose-dataflash_mmc_mux-command.patch;patch=1 \
	file://at91/0006-libarm-board.c-Gets-overwritten-workaround.patch;patch=1 \
	file://at91/0007-fat.c-Add-DEBUG-currently-disabled.patch;patch=1 \
	file://at91/0008-env_dataflash.c-More-robust-handling.patch;patch=1 \
	file://at91/0009-cmd_debug.c-Add-a-generic-function-for-debug-vars.patch;patch=1 \
	file://at91/0010-debug.h-Add-header-for-debug-variables.patch;patch=1 \
	file://at91/0011-common-Makefile-Add-cmd_debug.c-to-build.patch;patch=1 \
	file://at91/0012-cmd_mci.c-Support-writing-out-AT91-mci-config.patch;patch=1 \
	file://at91/0013-atmel_dataflash.c-Status-printout-depend-on-DEBUG.patch;patch=1 \
	file://at91/0014-AT91-MCI-Add-support-for-SD-Card.patch;patch=1 \
	file://at91/0015-sam9m10g45ek-Add-configuration-file.patch;patch=1 \
	"

TARGET_LDFLAGS = ""

inherit base

do_compile () {
       oe_runmake ${UBOOT_MACHINE}
       oe_runmake all
}

SRC_URI[md5sum] = "d94700614225f53c853dfe714eb5fa47"
SRC_URI[sha256sum] = "066615314fc90a314823ac975ca2a525a51fdad41802f4088a3a21ce073e8de6"

