inherit gpe
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget"
SECTION = "gpe"
DESCRIPTION = "Sokoban game for GTK"
PRIORITY = "optional"

SRC_URI += "file://fix_makefiles.patch;patch=1"

SRC_URI[md5sum] = "da4e3d05f18a44af4b43c76829ba110a"
SRC_URI[sha256sum] = "741af12ec81dff5ba79e6ce284146e26557f267b5a77ccc4c5644f2d5619dcf3"
