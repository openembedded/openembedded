DESCRIPTION = "Babl is a dynamic, any to any, pixel format conversion library."
LICENSE = "LGPL"

PV = "0.0.14+svn${SRCDATE}"

inherit gnome

SRC_URI = "svn://svn.gnome.org/svn/${PN};module=trunk"

S = "${WORKDIR}/trunk"

do_stage() {
        autotools_stage_all
}	


