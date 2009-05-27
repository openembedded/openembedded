require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman libpciaccess openssl xineramaproto libxinerama"
RDEPENDS += "hal"
PE = "2"

MESA_VER = "7.2"

export LDFLAGS += " -ldl "
