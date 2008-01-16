require python-efl.inc
DEPENDS += "ecore"
PR = "r5"

do_stage() {
    distutils_stage_all
}

