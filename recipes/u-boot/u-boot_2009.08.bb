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

SRC_URI[md5sum] = "cd4788ea1c6ac4f9b100b888a1063a6b"
SRC_URI[sha256sum] = "858fd04efd5b98e99fd1a074998b1a8ac5fbd07b176de1d20d8eb148492d949d"
