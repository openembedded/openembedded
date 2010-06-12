require python-iniparse_${PV}.bb
inherit native
DEPENDS = "python-native"
RDEPENDS_${PN} = ""
PR = "r2"

do_stage() {
	distutils_stage_all
}
