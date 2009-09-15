require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman libpciaccess openssl"
RDEPENDS += "hal"
PE = "2"
PR = "${INC_PR}.1"

SRC_URI += "file://drmfix.patch;patch=1 \
            file://sysroot_fix.patch;patch=1 \
            file://xorg-avr32-support.diff;patch=1 \
	    file://xorg-server-1.5.3-configure.patch;patch=1 \
	    file://xorg-server-1.5.3-glcore-prepare-for-dynamic.patch;patch=1 \
"

MESA_VER = "7.2"

export LDFLAGS += " -ldl "
