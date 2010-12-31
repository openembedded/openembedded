PR = "r0"
require u-boot.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 "
SRC_URI[md5sum] = "9024bbceabd176ae1d52df6db2e84bda"
SRC_URI[sha256sum] = "1705772db7a18635693676abb8818542167cb131921c456a1edd0ed47e6b77fe"


TARGET_LDFLAGS = ""

inherit base

do_compile () {
       oe_runmake ${UBOOT_MACHINE}
       oe_runmake all
}

