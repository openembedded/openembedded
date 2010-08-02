require xorg-lib-common.inc
DESCRIPTION = "X11 Input extension library"
DEPENDS += "libxext inputproto"
PE = "1"
PR = "${INC_PR}.0"

# because of broken ASCIIDOC in configure.ac 
# http://cgit.freedesktop.org/xorg/lib/libXi/commit/?h=libXi-1.3-branch&id=d7d8a9e4fc37ab0f865e74ea1871617a3b542906
DEFAULT_PREFERENCE = "-1"

SRC_URI[archive.md5sum] = "75324546e3d1c0cce9d508feb05e4ed0"
SRC_URI[archive.sha256sum] = "c38e88783f0f4dd2bd547f182060e83b5a963c973a6b0bb4e16be4c5e1776111"

XORG_PN = "libXi"
