inherit gpe
LICENSE = "GPL"
DESCRIPTION = "Teleport app"
DEPENDS = "gtk+ libgpewidget libdisplaymigration libgcrypt sqlite"
PRIORITY = "optional"

SRC_URI += "file://makefile-fix.patch;patch=1"


SRC_URI[md5sum] = "ae571a20333f90d4b79b68c446387925"
SRC_URI[sha256sum] = "266d6ec9795c2b480101c8754988df68da2c5b3579687bf51ae31000b08ba8bd"
