LICENSE     = "LiPS"
DESCRIPTION = "GSM Short message application"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ dbus-glib libmsgenabler libabenabler libiac libgpewidget libgpephone"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpephone autotools

FILES_${PN} += "${datadir}/conf ${datadir}/graphic"
