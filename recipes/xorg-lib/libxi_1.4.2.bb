require xorg-lib-common.inc
DESCRIPTION = "X11 Input extension library"
DEPENDS += "libxext inputproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "3d14f7bfc4a4335cf0144de9b67a5444"
SRC_URI[archive.sha256sum] = "272b8041efc0a0203fb0ba33481ddec989539aed862181b58c8c3e410e325691"

XORG_PN = "libXi"
