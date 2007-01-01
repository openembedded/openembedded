DESCRIPTION = "Bacon is a multimedia library"
LICENSE = "GPLv2"

DEPENDS = "glib-2.0"

PV = "0.0+svn${SRCDATE}"

inherit gnome

SRC_URI = "svn://svn.gnome.org/svn/${PN}/;module=trunk"

S = "${WORKDIR}/trunk"

do_stage() {
	autotools_stage_all
}




