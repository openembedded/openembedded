DESCRIPTION = "RTC alarm handling library for GPE"
MAINTAINER = "Philippe De Swert <philippedeswert@scarlet.be>"
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 sqlite libgpewidget"
PR = "r0"
PV = "0.16+svn${SRCDATE}"

DEFAULT_PREFERENCE = "-1"

inherit autotools pkgconfig gpe

SRC_URI = "svn://projects.linuxtogo.org/svn/gpe/trunk/base;module=${PN}"

S = "${WORKDIR}/${PN}"


do_stage () {
        autotools_stage_all
}
