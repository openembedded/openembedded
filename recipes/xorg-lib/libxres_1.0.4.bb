require xorg-lib-common.inc

DESCRIPTION = "X11 Resource extension library"
DEPENDS += "libxext resourceproto"
PR = "r1"
PE = "1"

XORG_PN = "libXres"

SRC_URI[archive.md5sum] = "4daf91f93d924e693f6f6ed276791be2"
SRC_URI[archive.sha256sum] = "457f567a70ef8798cfb32f897ffa52c3f010923b07414b3a42277f56877572df"
