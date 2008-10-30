require python-efl.inc
DEPENDS += "evas eina"
PV = "0.3.0+svnr${SRCREV}"
PR = "r0"

do_stage() {
	distutils_stage_all
}
