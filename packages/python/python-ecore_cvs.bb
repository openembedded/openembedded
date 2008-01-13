require python-efl.inc
DEPENDS += "ecore"

PR = "r3"

do_stage() {
    distutils_stage_all
}

