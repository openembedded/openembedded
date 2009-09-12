require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman libpciaccess openssl dri2proto glproto mesa"
PE = "2"
PR = "r4.74"

SRC_URI += "file://sysroot_fix.patch;patch=1"

EXTRA_OECONF += "--disable-xephyr --disable-config-hal --enable-xinerama"
EXTRA_OECONF += " --disable-glx-tls --enable-dri2"

export LDFLAGS += " -ldl "
