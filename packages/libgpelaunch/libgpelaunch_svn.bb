MAINTAINER = "Philippe De Swert <philippedeswert@scarlet.be>"
LICENSE = "LGPL"
DESCRIPTION = "GPE program launcher library"
SECTION = "libs"
DEPENDS = "gtk+ startup-notification"
PR = "r0"
PV = "0.14+svn${SRCDATE}"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "svn://projects.linuxtogo.org/svn/gpe/trunk/base;module=${PN}"

S = "${WORKDIR}/${PN}"

inherit autotools pkgconfig

FILES_${PN}-dbg += "/usr/libexec/libgpelaunch/.debug"

do_stage() {
	autotools_stage_all
}
