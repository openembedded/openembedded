LICENSE     = "LiPS"
DESCRIPTION = "Calendar application for GPE Phone Edition"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ libgpewidget libgpephone libgemwidget dbus-glib libcalenabler libiac"

GPE_TARBALL_SUFFIX= "gz"
inherit gpephone autotools

FILES_${PN} += "${datadir}/database ${datadir}/res"
