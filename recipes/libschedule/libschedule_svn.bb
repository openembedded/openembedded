DESCRIPTION = "RTC alarm handling library for GPE"
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 sqlite libgpewidget"
PV = "0.16+svn${SRCDATE}"
PR = "r0"

inherit autotools pkgconfig gpe

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/${PN}"

do_stage () {
        autotools_stage_all
}

DEFAULT_PREFERENCE = "-1"
