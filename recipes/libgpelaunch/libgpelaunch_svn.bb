DESCRIPTION = "GPE program launcher library"
SECTION = "libs"
LICENSE = "LGPL"
DEPENDS = "gtk+ startup-notification"
PV = "0.14+svn${SRCDATE}"
PR = "r0"

inherit autotools pkgconfig

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/${PN}"

do_stage() {
 autotools_stage_all
}

FILES_${PN}-dbg += "${libexecdir}/libgpelaunch/.debug"

DEFAULT_PREFERENCE = "-1"
