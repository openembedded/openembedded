require gnome-desktop.inc

PR = "r2"
inherit gnome pkgconfig

DEPENDS += "gnome-doc-utils"

SRC_URI += "file://scrollkeeper.patch;patch=1 \
            file://no-desktop-docs.patch;patch=1;pnum=0"

SRC_URI[archive.md5sum] = "e92edb17cd75faca45a4fe2d6806bdd8"
SRC_URI[archive.sha256sum] = "56c7dbe56e6a9fbcd3730c55892734a9daff23a86d69f49a381a4c965732f9d1"
