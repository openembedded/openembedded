PR = "r1"
require u-boot.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_lite5200 = "1"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 "

TARGET_LDFLAGS = ""

inherit base

do_compile () {
       oe_runmake ${UBOOT_MACHINE}
       oe_runmake all
}

SRC_URI[md5sum] = "2bf5ebf497dddc52440b1ea386cc1332"
SRC_URI[sha256sum] = "902d1b2c15787df55186fae4033685fb0c5a5a12755a08383e97c4a3e255925b"

