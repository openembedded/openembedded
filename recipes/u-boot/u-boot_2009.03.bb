PR = "r1"
require u-boot.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_hipox = "1"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 "

SRC_URI_append_hipox = "file://00-hipox.patch;patch=1 "

TARGET_LDFLAGS = ""

UBOOT_MACHINE_hipox  = "hipox_config"

inherit base

do_compile () {
	oe_runmake ${UBOOT_MACHINE}
	oe_runmake all
}
