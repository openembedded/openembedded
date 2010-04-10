require xorg-lib-common.inc

DESCRIPTION = "X11 Direct Graphics Access extension library"
DEPENDS += "libxext xf86dgaproto"
PR = "r1"
PE = "1"

XORG_PN = "libXxf86dga"

SRC_URI[archive.md5sum] = "5b0e752c71a23e9d1290cad44a7c7c75"
SRC_URI[archive.sha256sum] = "8c68f429942b1258cff0fb27505645a463690374ecf318ae660ff4cde7a03db9"
