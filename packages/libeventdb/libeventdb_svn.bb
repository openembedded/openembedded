DESCRIPTION = "Database access library for GPE calendar"
LICENSE     = "LGPL"
SECTION = "gpe/libs"
PRIORITY = "optional"

DEPENDS  = "libgpewidget libgpepimc sqlite"

PV = "0.90+svn${SRCDATE}"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

inherit pkgconfig gpe autotools

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/${PN}"

do_stage () {
    autotools_stage_all
}
