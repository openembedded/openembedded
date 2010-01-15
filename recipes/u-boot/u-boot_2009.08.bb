PR = "r1"
require u-boot.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_at91sam9g20ek = "1"
DEFAULT_PREFERENCE_at91sam9g45ek = "1"
DEFAULT_PREFERENCE_igep0020 = "1"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 "

SRC_URI_append_igep0020 = " \
	file://update-mach-types.patch;patch=1 \
	file://add-board-support-for-IGEP-v2-series-rev-B.patch;patch=1 \
"

TARGET_LDFLAGS = ""

inherit base

do_compile () {
       oe_runmake ${UBOOT_MACHINE}
       oe_runmake all
}
