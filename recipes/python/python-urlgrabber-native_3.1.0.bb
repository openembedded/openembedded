require python-urlgrabber_${PV}.bb
inherit native
DEPENDS = "python-native"
RDEPENDS = ""
PR = "r1"

do_stage() {
	distutils_stage_all
}
