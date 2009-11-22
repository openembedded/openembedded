DESCRIPTION = "Babl is a dynamic, any to any, pixel format conversion library."
LICENSE = "LGPL"

SRCREV = "349"
PV = "0.0.23+svnr${SRCPV}"
PR = "r1"
PE = "1"

inherit gnome

SRC_URI = "svn://svn.gnome.org/svn/${PN};module=trunk"

S = "${WORKDIR}/trunk"

do_stage() {
        autotools_stage_all
}	


FILES_${PN} += "${libdir}/babl-0.0/"
FILES_${PN}-dbg += "${libdir}/babl-0.0/.debug/"


