LICENSE     = "LiPS"
DESCRIPTION = "Quickdial application and backend"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"
PV = "0.0+svnr-${SRCREV}"

DEFAULT_PREFERENCE = "-1"

DEPENDS = "gtk+ librecord2 libgpephone"

inherit gpephone autotools pkgconfig

SRC_URI = "${GPEPHONE_SVN}"

S = "${WORKDIR}/${PN}"

EXTRA_OECONF = "--disable-hiker"

FILES_${PN} += "${datadir}/qdial/database"
