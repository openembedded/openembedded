DESCRIPTION = "RTC alarm handling library for GPE"
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 sqlite libgpewidget"
PV = "0.16+svn${SRCDATE}"
PR = "r0"

SRC_URI = "svn://projects.linuxtogo.org/svn/gpe/trunk/base;module=${PN}"

S = "${WORKDIR}/${PN}"

inherit autotools pkgconfig gpe

do_stage () {
        autotools_stage_all
}

DEFAULT_PREFERENCE = "-1"
