PR = "r0"
require u-boot.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mpc8315e-rdb = "1"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 "

TARGET_LDFLAGS = ""

inherit base

do_compile () {
	oe_runmake ${UBOOT_MACHINE}
	oe_runmake all
}

SRC_URI[md5sum] = "dfbe65c1e31bb7de5f5b03d50de192b5"
SRC_URI[sha256sum] = "b0037cf21b67779ef5a0c585b32e46bde3b78df889484c78bb4318c9b448f560"
