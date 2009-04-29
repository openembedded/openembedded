require python-efl.inc
DEPENDS += "evas"

do_stage() {
	distutils_stage_all
	distutils_stage_headers
}
