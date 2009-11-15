LICENSE     = "LiPS"
DESCRIPTION = "Useen tool"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"
PV = "0.0+svnr${SRCPV}"
PE = "1"

DEFAULT_PREFERENCE = "-1"

DEPENDS = "glib-2.0"

inherit gpephone autotools pkgconfig

SRC_URI = "${GPEPHONE_SVN}"

S = "${WORKDIR}/${PN}"
