LICENSE     = "LiPS"
DESCRIPTION = "Quickdial application and backend"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"
PV = "0.0+svnr-${SRCREV}"

SRCREV_pn-${PN} ?= "1393"

DEFAULT_PREFERENCE = "-1"

DEPENDS = "gtk+ librecord2 libgpephone hiker"

inherit gpephone autotools pkgconfig

SRC_URI = "${GPEPHONE_SVN}"

S = "${WORKDIR}/${PN}"


FILES_${PN} += "${datadir}/qdial/database"
