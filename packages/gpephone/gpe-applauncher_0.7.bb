LICENSE     = "GPL"
DESCRIPTION = "A cellphone application launcher."
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r1"

DEPENDS = "gtk+ libgpewidget libgpephone libgpelaunch dbus-glib libxsettings-client"

GPE_TARBALL_SUFFIX= "gz"
inherit gpephone autotools

SRC_URI += " file://default-icon.patch;patch=1;pnum=0"

#EXTRA_OECONF = "--enable-gridlayout"

FILES_${PN} += '${datadir}/themes'
