require python-efl.inc
DEPENDS += "evas"
PR = "r4"

do_stage() {
	distutils_stage_all
}
