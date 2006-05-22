LICENSE     = "GPL"
DESCRIPTION = "handoff library for GPE calendar"
SECTION  = "gpe/libs"
PRIORITY = "optional"
DEPENDS  = "glib-2.0"
PV = "0.1+cvs${SRCDATE}"
PR = "r0"
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"
DEFAULT_PREFERENCE = "-1"

inherit pkgconfig gpe autotools

SRC_URI = "${HANDHELDS_CVS};module=gpe/base/${PN}"

S = ${WORKDIR}/${PN}

do_stage () {
autotools_stage_all
}
