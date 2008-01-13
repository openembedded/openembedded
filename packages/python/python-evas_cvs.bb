require python-efl.inc
DEPENDS += "evas"

PR = "r3"

do_stage() {
	distutils_stage_all
}
