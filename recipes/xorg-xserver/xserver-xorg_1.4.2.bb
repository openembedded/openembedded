require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman"
RDEPENDS_${PN} += "hal"
PE = "1"
PR = "${INC_PR}.1"

SRC_URI += "file://drmfix.patch \
            file://pkgconfig_fix.patch \
            file://sysroot_fix.patch \
            file://xcalibrate-xorg.diff \
"

MESA_VER = "7.0.2"

export LDFLAGS += " -ldl "

SRC_URI[archive.md5sum] = "fa2915ae377f61c340a18ebef484b64b"
SRC_URI[archive.sha256sum] = "829c66ec4c295822700067c87afae796b8e67530cc65a7b83060ea29a4ff316d"
