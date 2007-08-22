require python-efl.inc
DEPENDS += "evas"

PR = "r2"

do_stage() {
	distutils_stage_all
}
