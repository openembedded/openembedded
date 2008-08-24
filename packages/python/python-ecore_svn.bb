require python-efl.inc
DEPENDS += "python-evas ecore"
RDEPENDS += "python-evas"
PV = "0.2.1+svnr${SRCREV}"
PR = "r2"

do_stage() {
    distutils_stage_all
}
