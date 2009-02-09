require python-twisted_${PV}.bb

RDEPENDS_${PN} = ""

inherit native

do_stage() {
	distutils_stage_all
}
