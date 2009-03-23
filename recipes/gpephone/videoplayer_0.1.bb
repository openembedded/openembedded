LICENSE     = "LiPS"
DESCRIPTION = "Video player application"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ libgpewidget libgpephone libgemwidget dbus-glib gst-plugins-base libiac"

GPE_TARBALL_SUFFIX= "gz"
inherit gpephone autotools

FILES_${PN} += "${datadir}/database ${datadir}/res"
