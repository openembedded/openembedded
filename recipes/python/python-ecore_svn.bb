require python-efl.inc
DEPENDS += "python-evas ecore"
RDEPENDS += "python-evas"

do_stage() {
    distutils_stage_all
}
