require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman libpciaccess openssl"
RDEPENDS_${PN} += "hal"
PE = "2"
PR = "${INC_PR}.2"

SRC_URI += "file://drmfix.patch \
            file://sysroot_fix.patch \
            file://xorg-avr32-support.diff \
	    file://xorg-server-1.5.3-configure.patch \
	    file://xorg-server-1.5.3-glcore-prepare-for-dynamic.patch \
"

MESA_VER = "7.2"

export LDFLAGS += " -ldl "

SRC_URI[archive.md5sum] = "308971036e25250e7fe3cccfd5a120f8"
SRC_URI[archive.sha256sum] = "a680174f54be7763819e5275c5d5d44fc9e9b6f8e9351dd45c150eb4c182d5bb"
