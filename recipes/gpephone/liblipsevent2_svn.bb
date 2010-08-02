DESCRIPTION = "LiPS event model library."
LICENSE     = "LiPS"
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0"
PV = "0.0+svnr-${SRCREV}"
PR          = "r0"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_SVN}"

S = ${WORKDIR}/${PN}

