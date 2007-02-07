LICENSE     = "GPL"
DESCRIPTION = "A cellphone application launcher."
SECTION     = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ libgpewidget libgpephone libgpelaunch dbus-glib libxsettings-client"

GPE_TARBALL_SUFFIX= "gz"
inherit gpephone autotools

#EXTRA_OECONF = "--enable-gridlayout"

FILES_${PN} += '${datadir}/themes'
