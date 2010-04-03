require python-efl.inc
SRCREV = "${EFL_SRCREV}"
DEPENDS += "evas"

do_stage() {
	distutils_stage_all
	distutils_stage_headers
}
