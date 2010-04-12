require python-setuptools_${PV}.bb
inherit native

FILESPATH = "${FILE_DIRNAME}/python-setuptools"
DEPENDS = "python-native"

do_stage() {
	distutils_stage_all
}

SRC_URI[md5sum] = "3864c01d9c719c8924c455714492295e"
SRC_URI[sha256sum] = "e6190497301b6cb1484b9e6173723452c8df1b4cd9ea97af75c9589b1c34b3d8"
