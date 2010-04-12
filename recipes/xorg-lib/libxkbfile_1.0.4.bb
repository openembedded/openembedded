require xorg-lib-common.inc

DESCRIPTION = "X11 keyboard file manipulation library"
LICENSE= "GPL"
DEPENDS += "virtual/libx11 kbproto"
PR = "r1"
PE = "1"

SRC_URI[archive.md5sum] = "12b4ceb5d42b520228b5fb40a96ae6c5"
SRC_URI[archive.sha256sum] = "468ade4eaa3951a7c34b6ae1c290ab1a1d364ee36c5c455ef0df15550825b8ae"
