require xorg-lib-common.inc
DESCRIPTION = "X font library (used by the X server)."
PRIORITY = "optional"
LICENSE = "BSD-X"
DEPENDS += " freetype fontcacheproto zlib xproto xtrans fontsproto libfontenc"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI += "file://no-scalable-crash.patch"
SRC_URI[archive.md5sum] = "83b8e21f6ee22512a8f72ba51e2d74f6"
SRC_URI[archive.sha256sum] = "374a2ca12f62a4d9f09a17a34765a5289cefa9db7f9f0913e1c3731b4088aad8"

BBCLASSEXTEND = "native"

XORG_PN = "libXfont"
