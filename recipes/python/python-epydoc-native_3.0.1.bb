require python-epydoc_${PV}.bb
DEPENDS = "python-native"
inherit native

do_stage() {
	distutils_stage_all
}

