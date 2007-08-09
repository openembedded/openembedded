DESCRIPTION = "Data interchange library for GPE"
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "libmimedir libeventdb libtododb"
PV = "0.50+svn${SRCDATE}"
PR = "r1"

inherit pkgconfig gpe autotools

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/${PN}"

do_stage () {
	autotools_stage_all
}


DEFAULT_PREFERENCE = "-1"
