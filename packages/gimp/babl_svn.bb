DESCRIPTION = "Babl is a dynamic, any to any, pixel format conversion library."
LICENSE = "LGPL"

inherit gnome

SRC_URI = "svn://svn.gnome.org/svn/${PN};module=trunk"

S = "${WORKDIR}/trunk"

do_stage() {
        autotools_stage_all
}	


