PR = "r1"
require u-boot.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_lite5200 = "1"
DEFAULT_PREFERENCE_tqm8540 = "1"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 "

TARGET_LDFLAGS = ""

inherit base

do_compile () {
       oe_runmake ${UBOOT_MACHINE}
       oe_runmake all
}

SRC_URI[md5sum] = "cd42bc64b6edafa6930ce299a144503e"
SRC_URI[sha256sum] = "790ccb12d99fc527a8b8d20dfdf491795d30f87aa0902f8cbda196583aa20bc8"

