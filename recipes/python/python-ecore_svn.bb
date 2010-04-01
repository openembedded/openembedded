require python-efl.inc
SRCREV = "${EFL_SRCREV}"
DEPENDS += "python-evas ecore"
RDEPENDS += "python-evas"

do_stage() {
    distutils_stage_all
}
