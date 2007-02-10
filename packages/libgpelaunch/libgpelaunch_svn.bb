DESCRIPTION = "GPE program launcher library"
SECTION = "libs"
LICENSE = "LGPL"
DEPENDS = "gtk+ startup-notification"
PV = "0.14+svn${SRCDATE}"
PR = "r0"

SRC_URI = "svn://projects.linuxtogo.org/svn/gpe/trunk/base;module=${PN}"

S = "${WORKDIR}/${PN}"

inherit autotools pkgconfig

do_stage() {
 autotools_stage_all
}

FILES_${PN}-dbg += "${libexecdir}/libgpelaunch/.debug"

DEFAULT_PREFERENCE = "-1"
