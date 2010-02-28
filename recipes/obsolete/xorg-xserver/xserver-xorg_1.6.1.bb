require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman libpciaccess openssl xineramaproto libxinerama"
RDEPENDS += "hal"
PE = "2"
PR = "${INC_PR}.1"

SRC_URI += "file://sysroot_fix.patch;patch=1 \
	    file://dolt-fix.patch;patch=1"

# This requires support in pixman, which the default one doesn't have
SRC_URI_append_angstrom = " file://hack-assume-pixman-supports-overlapped-blt.patch;patch=1"

MESA_VER = "7.2"

export LDFLAGS += " -ldl "
