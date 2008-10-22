require gnome-desktop.inc

PR = "r2"

inherit gnome pkgconfig

DEPENDS += "gnome-doc-utils gnome-vfs"

SRC_URI += "file://scrollkeeper.patch;patch=1 \
            file://no-desktop-docs.patch;patch=1;pnum=0"
