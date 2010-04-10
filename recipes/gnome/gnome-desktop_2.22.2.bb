require gnome-desktop.inc

inherit gnome pkgconfig

DEPENDS += "gnome-doc-utils gnome-vfs"

SRC_URI += "file://scrollkeeper.patch;patch=1 \
            file://no-desktop-docs.patch;patch=1;pnum=0"

SRC_URI[archive.md5sum] = "6d6271cfa135ce016126414d929b8fb7"
SRC_URI[archive.sha256sum] = "4bd3141b2c668b24b43ac10a7a7040ce0717d8f088aee8a93ef261e446d88818"
