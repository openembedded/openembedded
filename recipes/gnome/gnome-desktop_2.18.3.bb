require gnome-desktop.inc

PR = "r2"

inherit gnome pkgconfig

DEPENDS += "gnome-doc-utils gnome-vfs"

SRC_URI += "file://scrollkeeper.patch;patch=1 \
            file://no-desktop-docs.patch;patch=1;pnum=0"

SRC_URI[archive.md5sum] = "98de3b7d0da690da8b94cddc74f3914b"
SRC_URI[archive.sha256sum] = "8997a2ceca2dbb28fb402e23ea5f255b68c59ea4f932b253e2843bfe62af7c64"
