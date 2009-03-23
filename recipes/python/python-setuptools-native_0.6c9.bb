require python-setuptools_${PV}.bb
inherit native

FILESPATH = "${FILE_DIRNAME}/python-setuptools"
DEPENDS = "python-native"

do_stage() {
	distutils_stage_all
}
