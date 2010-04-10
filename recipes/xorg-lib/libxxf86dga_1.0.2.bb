require xorg-lib-common.inc

DESCRIPTION = "X11 Direct Graphics Access extension library"
DEPENDS += "libxext xf86dgaproto"
PR = "r1"
PE = "1"

XORG_PN = "libXxf86dga"

SRC_URI[archive.md5sum] = "6f5f621804ee652b6cc6f2025c517c78"
SRC_URI[archive.sha256sum] = "59175230a00a1fb359148f36eadb50fc6cb080849379ccb0e43c6cbb97309a25"
