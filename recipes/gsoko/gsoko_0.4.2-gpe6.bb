inherit gpe
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget"
SECTION = "gpe"
DESCRIPTION = "Sokoban game for GTK"
PRIORITY = "optional"
PR = "r1"

SRC_URI += " \
            file://fix_makefiles.patch;patch=1 \
           "

SRC_URI[md5sum] = "b10893acb76c5d016c9bcfff6ba9418b"
SRC_URI[sha256sum] = "484f528602bd64df26a1d1db6e249476df80fe31ee8b3f85bc246a1ab73e7fe7"
