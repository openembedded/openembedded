LICENSE = "LGPL"
SECTION = "x11/gnome"

inherit autotools_stage gnome lib_package

DEPENDS = "gtk+ dbus"


SRC_URI[archive.md5sum] = "02b9e41c70ca738e1aa914f400fc1f05"
SRC_URI[archive.sha256sum] = "d627a10f523af14e9ead655ebab3a26e7faeea006bdfa7739bc4c04058ddf4c6"
