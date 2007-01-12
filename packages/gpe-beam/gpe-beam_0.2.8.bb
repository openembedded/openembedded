require ${PN}.inc

RDEPENDS = "irda-utils"

SRC_URI += "file://dbus-new-api.patch;patch=1"

inherit gpe
