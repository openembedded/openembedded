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

SRC_URI[archive.md5sum] = "ed0878bf32a24d4948c3b8a122a39eff"
SRC_URI[archive.sha256sum] = "0edbaa994797cb7944a4129d33b634ad99164b21ec32355d56996a178d38bfcf"
