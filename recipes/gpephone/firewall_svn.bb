LICENSE     = "LiPS"
DESCRIPTION = "Cellphone firewall tool"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"
PV = "0.0+svnr-${SRCREV}"

DEFAULT_PREFERENCE = "-1"

DEPENDS = "gtk+ libmsgenabler libabenabler libiac libgpewidget libgpephone gconf-dbus"

inherit gpephone autotools pkgconfig

SRC_URI = "${GPEPHONE_SVN}"

S = "${WORKDIR}/${PN}"
