LICENSE     = "LiPS"
DESCRIPTION = "LiPS address book"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ libgpewidget libgpephone dbus-glib libabenabler libiac libim"

GPE_TARBALL_SUFFIX= "bz2"
inherit gpephone autotools

FILES_${PN} += "${datadir}/database"

SRC_URI[md5sum] = "b8a0821ef12a2243b537fde3207c8691"
SRC_URI[sha256sum] = "85847b8e25d56f7d3af29207d6878601390e97dc5119e4d35bd0b096c27a478d"
