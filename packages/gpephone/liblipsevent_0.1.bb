LICENSE     = "LiPS"
DESCRIPTION = "LiPS event model library."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0"
PR          = "r1"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_MIRROR}/${P}/lips_event-${PV}.tar.gz"

S = ${WORKDIR}/lips_event-${PV}

do_stage () {
	autotools_stage_all
}
