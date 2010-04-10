require xorg-lib-common.inc

DESCRIPTION = "X11 Direct Graphics Access extension library"
DEPENDS += "libxext xf86dgaproto"
PR = "r1"
PE = "1"

XORG_PN = "libXxf86dga"

SRC_URI[archive.md5sum] = "368837d3d7a4d3b4f70be48383e3544e"
SRC_URI[archive.sha256sum] = "8d37f8895ecff15cb821a3e77bd505598983a5c6eae546e77e2d3070a8de5616"
