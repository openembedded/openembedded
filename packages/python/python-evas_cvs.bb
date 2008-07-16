require python-efl.inc
DEPENDS += "evas"
PV = "0.2.1+cvs${SRCDATE}"
PR = "r0"

do_compile_prepend() {
	touch include/evas/__init__.py
}

do_stage() {
	distutils_stage_all
}
