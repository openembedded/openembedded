require xorg-lib-common.inc

DESCRIPTION = "X Display Manager Control Protocol library"
DEPENDS += "xproto"
PROVIDES = "xdmcp"
PR = "r1"
PE = "1"

XORG_PN = "libXdmcp"

SRC_URI[archive.md5sum] = "d60941d471800f41a3f19b24bea855a7"
SRC_URI[archive.sha256sum] = "d8033a2fae20fed6de4f16b73ad69ca1c511e7da31c88e9bc6e75976187378cb"
