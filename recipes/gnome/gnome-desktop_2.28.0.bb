require gnome-desktop.inc

inherit gnome pkgconfig

DEPENDS += "gnome-doc-utils gnome-vfs libxrandr"

# FIXME: docs build requires gnome-doc-utils-native (for xml2po) and docbook
SRC_URI += "file://no-desktop-docs.patch;patch=1;pnum=0"
