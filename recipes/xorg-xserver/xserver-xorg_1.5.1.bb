require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman libpciaccess openssl"
RDEPENDS_${PN} += "hal"
PE = "1"
PR = "${INC_PR}.1"

SRC_URI += "file://drmfix.patch \
            file://sysroot_fix.patch"

MESA_VER = "7.2"

export LDFLAGS += " -ldl "

SRC_URI[archive.md5sum] = "d16f5a033f001c9069b4141194614da2"
SRC_URI[archive.sha256sum] = "2f36880bffaee0a5b2b704376a02b22066b6842445e1d77da698854e5973eb21"
