require xorg-lib-common.inc
DESCRIPTION = "X11 Input extension library"
DEPENDS += "libxext inputproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "26f93781356b1fdde08f7ee9cd5884d6"
SRC_URI[archive.sha256sum] = "a6034b57ab65fd89584d23403f613c1e1ad1679614fa8562b7438880596ddc3a"

XORG_PN = "libXi"
