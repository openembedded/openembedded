PR = "r0"
require u-boot.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_overo = "1"
DEFAULT_PREFERENCE_mpc8313e-rdb = "1"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 \
    file://tools_fwenv.patch"
SRC_URI[md5sum] = "91d02124c94368557d0e9ac05fb8c33f"
SRC_URI[sha256sum] = "08677f66d8d4ee542f6599f580cdffdf730544e1803f9d3739117d6f6d68083e"

TARGET_LDFLAGS = ""

inherit base

do_compile () {
       oe_runmake ${UBOOT_MACHINE}
       oe_runmake all
       oe_runmake 'HOSTCC=${CC}' env
}

