LICENSE     = "LiPS"
DESCRIPTION = "Voice call event history"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ dbus-glib libgpewidget libgpephone libiac libchenabler"

inherit gpephone autotools

SRC_URI = "${GPEPHONE_MIRROR}/vochistory-${PV}/callhistory-${PV}.tar.bz2"
S = "${WORKDIR}/callhistory-${PV}"