require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman libpciaccess openssl"
PE = "1"
PR = "r1"

SRC_URI += "file://drmfix.patch;patch=1 \
            file://sysroot_fix.patch;patch=1"

MESA_VER = "7.2"

export LDFLAGS += " -ldl "
