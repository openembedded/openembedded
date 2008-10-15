LICENSE     = "GPL"
DESCRIPTION = "handoff library for GPE calendar"
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS  = "glib-2.0"
PV = "0.1+svn${SRCDATE}"
PR = "r0"
DEFAULT_PREFERENCE = "-1"

inherit pkgconfig gpe autotools

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/${PN}"

do_stage () {
autotools_stage_all
}
