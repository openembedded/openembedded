require python-efl.inc
DEPENDS += "python-evas ecore"
RDEPENDS += "python-evas"
PV = "0.3.0+svnr${SRCREV}"
PR = "r0"

do_stage() {
    distutils_stage_all
}
