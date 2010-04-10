require ${PN}.inc

RDEPENDS = "irda-utils"

SRC_URI += "file://dbus-new-api.patch;patch=1"

inherit gpe

SRC_URI[md5sum] = "2730dc64c643d4503346eca41bf40cc2"
SRC_URI[sha256sum] = "056227431c47301b9ebfd9e12a5b2597d0f625697299b7027babf81d335b9d45"
