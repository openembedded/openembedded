DESCRIPTION = "Bacon is a multimedia library"
LICENSE = "GPLv2"

DEPENDS = "glib-2.0"

PV = "0.0+cvs${SRCDATE}"

inherit gnome

SRC_URI = "cvs://anonymous@anoncvs.gnome.org/cvs/gnome;module=${PN}"

S = "${WORKDIR}/${PN}"

do_stage() {
	autotools_stage_all
}	




