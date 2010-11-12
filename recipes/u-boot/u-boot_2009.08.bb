PR = "r1"
require u-boot.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_at91sam9g20ek = "1"
DEFAULT_PREFERENCE_at91sam9g45ek = "1"
DEFAULT_PREFERENCE_igep0020 = "1"
DEFAULT_PREFERENCE_babbage  = "1"
DEFAULT_PREFERENCE_mx25-3stack	 = "1"

SRC_URI = "\
    ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 \
    file://dont-inline-weak-symbols.patch \
"

SRC_URI_append_igep0020 = " \
	file://update-mach-types.patch \
	file://add-board-support-for-IGEP-v2-series-rev-B.patch \
"
SRC_URI_append_babbage = " \
           http://download.berlios.de/mx25patches/u-boot-v2009.08-imx-09.12.00.patch.bz2;patch=1;name=ubootbabbage \
           "
SRC_URI_append_mx25-3stack = " \
           http://download.berlios.de/mx25patches/u-boot-v2009.08-imx-09.12.00.patch.bz2;patch=1;name=ubootbabbage \
           "

SRC_URI[ubootbabbage.md5sum] = "b7bc4870b647de422b983ea3acc367a5"
SRC_URI[ubootbabbage.sha256sum] = "c65baf791f987126251dfcb5fa100ffef6cf6b668b71d57c2ca4e1128870ff9b"

TARGET_LDFLAGS = ""

inherit base

do_compile () {
       oe_runmake ${UBOOT_MACHINE}
       oe_runmake all
}

SRC_URI[md5sum] = "cd4788ea1c6ac4f9b100b888a1063a6b"
SRC_URI[sha256sum] = "858fd04efd5b98e99fd1a074998b1a8ac5fbd07b176de1d20d8eb148492d949d"
