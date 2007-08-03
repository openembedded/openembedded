LICENSE     = "LiPS"
DESCRIPTION = "LiPS address book"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"
PV = "0.1+svn-${SRCDATE}"

DEFAULT_PREFERENCE = "-1"

DEPENDS = "gtk+ libgpewidget libgpephone dbus-glib libabenabler libiac libim"

inherit gpephone autotools

SRC_URI = "${GPEPHONE_SVN}"

S = "${WORKDIR}/${PN}"


FILES_${PN} += "${datadir}/database"
