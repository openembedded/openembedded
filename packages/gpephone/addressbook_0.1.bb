LICENSE     = "LiPS"
DESCRIPTION = "LiPS address book"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ libgpewidget libgpephone dbus-glib libabenabler libiac libim"

GPE_TARBALL_SUFFIX= "bz2"
inherit gpephone autotools

FILES_${PN} += "${datadir}/database"
