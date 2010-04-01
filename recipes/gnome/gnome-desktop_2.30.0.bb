require gnome-desktop.inc

inherit gnome pkgconfig

SRC_URI[archive.md5sum] = "211818d93cd1b5b54b880520fe5444c4"
SRC_URI[archive.sha256sum] = "cb80b676966127d8ee1a9b5ebbed1c23646d62ecdfccbb46d40f59633b4b127f"

DEPENDS += "gnome-doc-utils gnome-vfs libxrandr"

# FIXME: docs build requires gnome-doc-utils-native (for xml2po) and docbook
SRC_URI += "file://no-desktop-docs.patch;patch=1;pnum=0"
