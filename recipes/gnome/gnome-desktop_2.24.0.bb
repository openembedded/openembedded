require gnome-desktop.inc

inherit gnome pkgconfig

DEPENDS += "gnome-doc-utils gnome-vfs libxrandr"

SRC_URI += "file://scrollkeeper.patch;patch=1 \
            file://no-desktop-docs.patch;patch=1;pnum=0"

SRC_URI[archive.md5sum] = "a2cc0424619f271bf1a65cc0fbe782f0"
SRC_URI[archive.sha256sum] = "7ebe5b0c2bb296386f1d62c3a5d30ed50e353c8d9dc390b77e0b5fdf56e4dad9"
