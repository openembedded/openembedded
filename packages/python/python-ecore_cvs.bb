require python-efl.inc
DEPENDS += "ecore"

PR = "r2"

do_stage() {
    distutils_stage_all
}

