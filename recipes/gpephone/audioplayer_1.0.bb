LICENSE     = "LiPS"
DESCRIPTION = "An audio player for GPE phone edition."
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ libgpewidget libgpephone dbus-glib libabenabler libiac gstreamer libgemwidget"

GPE_TARBALL_SUFFIX= "bz2"
inherit gpephone autotools

FILES_${PN} += "${datadir}/themes"
