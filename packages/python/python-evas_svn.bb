require python-efl.inc
DEPENDS += "evas"
PV = "0.2.1+svnr${SRCREV}"
PR = "r1"

do_stage() {
	distutils_stage_all
}
