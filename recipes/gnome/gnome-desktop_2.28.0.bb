require gnome-desktop.inc

inherit gnome pkgconfig

DEPENDS += "gnome-doc-utils gnome-vfs libxrandr"

# FIXME: docs build requires gnome-doc-utils-native (for xml2po) and docbook
SRC_URI += "file://no-desktop-docs.patch;patch=1;pnum=0"

SRC_URI[archive.md5sum] = "73927d3c43d783f5d7d6cdbb4359d7d6"
SRC_URI[archive.sha256sum] = "976fde6c0764b7b26b633030032b992c4dcbbaefd29d118303de5f7258794ae5"
