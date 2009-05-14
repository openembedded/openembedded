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
