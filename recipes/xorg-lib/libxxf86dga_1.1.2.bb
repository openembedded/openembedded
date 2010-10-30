require xorg-lib-common.inc
DESCRIPTION = "X11 Direct Graphics Access extension library"
DEPENDS += "libxext xf86dgaproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "bbd5fdf63d4c107c8cb710d4df2012b4"
SRC_URI[archive.sha256sum] = "1ba652f562ce3fb3fef092ce5485eb7ef15b521124c901977b56d6f324605a06"

XORG_PN = "libXxf86dga"
