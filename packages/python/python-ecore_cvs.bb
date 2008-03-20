require python-efl.inc
DEPENDS += "python-evas ecore"
RDEPENDS += "python-evas"
PV = "0.2.1+cvs${SRCDATE}"
PR = "r1"

do_stage() {
    distutils_stage_all
}
