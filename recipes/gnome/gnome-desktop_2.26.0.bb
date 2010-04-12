require gnome-desktop.inc

inherit gnome pkgconfig

DEPENDS += "gnome-doc-utils gnome-vfs libxrandr"

SRC_URI += " \
            file://no-desktop-docs.patch;patch=1;pnum=0"

SRC_URI[archive.md5sum] = "796fc830e0baff24381809a7abe012f8"
SRC_URI[archive.sha256sum] = "3b3fe18bc30ad60f1bbbb2bc2d2ec14a2f9babb9312eb4834395b5839b7d7ee9"
