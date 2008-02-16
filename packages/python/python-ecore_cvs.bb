require python-efl.inc
DEPENDS += "python-evas ecore"
PV = "0.2.1+cvs${SRCDATE}"
PR = "r0"

do_stage() {
    distutils_stage_all
}

