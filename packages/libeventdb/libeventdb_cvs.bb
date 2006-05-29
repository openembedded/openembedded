LICENSE     = "LGPL"
DESCRIPTION = "Database access library for GPE calendar"
SECTION  = "gpe/libs"
PRIORITY = "optional"
DEPENDS  = "libgpewidget libgpepimc sqlite"
MAINTAINER  = "Florian Boor <florian.boor@kernelconcepts.de>"
PV = "0.30+cvs${SRCDATE}"
PR = "r0"
DEFAULT_PREFERENCE = "-1"

inherit pkgconfig gpe autotools

SRC_URI = "${HANDHELDS_CVS};module=gpe/base/${PN}"

S = ${WORKDIR}/${PN}

do_stage () {
autotools_stage_all
}
