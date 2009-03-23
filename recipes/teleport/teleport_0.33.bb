inherit gpe
LICENSE = "GPL"

DESCRIPTION = "Teleport app"
DEPENDS = "gtk+ libgpewidget libdisplaymigration libgcrypt sqlite"
SECTION = "gpe"
PRIORITY = "optional"
PR = "r2"

SRC_URI =+ "file://crypt.c \
		file://fix-desktop.patch;patch=1 \
		file://remove-tododb.patch;pnum=1;patch=1"
