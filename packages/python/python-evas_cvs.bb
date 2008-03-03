require python-efl.inc
DEPENDS += "evas"
PV = "0.2.1+cvs${SRCDATE}"
PR = "r0"

do_stage() {
	distutils_stage_all
}
