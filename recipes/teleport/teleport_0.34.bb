inherit gpe
LICENSE = "GPL"
DESCRIPTION = "Teleport app"
DEPENDS = "gtk+ libgpewidget libdisplaymigration libgcrypt sqlite"
PRIORITY = "optional"

SRC_URI += "file://makefile-fix.patch;patch=1"

