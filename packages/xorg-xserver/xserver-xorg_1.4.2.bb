require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman"
PE = "1"
PR = "r10"

SRC_URI += "file://drmfix.patch;patch=1 \
            file://pkgconfig_fix.patch;patch=1 \
            file://sysroot_fix.patch;patch=1 \
            file://xcalibrate-xorg.diff \
"

MESA_VER = "7.0.2"

export LDFLAGS += " -ldl "
