require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman"
RDEPENDS_${PN} += "hal"
PE = "1"
PR = "${INC_PR}.1"

SRC_URI += "file://drmfix.patch \
            file://pkgconfig_fix.patch \
            file://sysroot_fix.patch"

MESA_VER = "7.0.2"

export LDFLAGS += " -ldl "

SRC_URI[archive.md5sum] = "a06d9fe4f9f1d459ae02657f9ce64220"
SRC_URI[archive.sha256sum] = "51b142df328d427143705371f139a08ff3bcd6efe0eab91f4178ca4017c0ebc2"
