require python-twisted_${PV}.bb

inherit native

do_stage() {
	distutils_stage_all
}
