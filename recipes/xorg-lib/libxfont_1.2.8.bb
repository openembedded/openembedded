require xorg-lib-common.inc
PE = "1"

DESCRIPTION = "X font library (used by the X server)."
LICENSE= "BSD-X"
PRIORITY = "optional"

SRC_URI += "file://no-scalable-crash.patch;patch=1"

DEPENDS += " freetype fontcacheproto zlib xproto xtrans fontsproto libfontenc"
PROVIDES = "xfont"

XORG_PN = "libXfont"


SRC_URI[archive.md5sum] = "83b8e21f6ee22512a8f72ba51e2d74f6"
SRC_URI[archive.sha256sum] = "374a2ca12f62a4d9f09a17a34765a5289cefa9db7f9f0913e1c3731b4088aad8"
