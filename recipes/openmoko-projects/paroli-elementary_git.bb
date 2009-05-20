DESCRIPTION = "python-elementary paroli bindings"
DEPENDS = "python-cython-native python-pyrex-native python-numeric eina elementary"
RDEPENDS = "python-lang python-evas python-ecore python-edje" 
PV = "0.1+gitr${SRCPV}"
PR = "r1"

inherit setuptools

SRC_URI = "git://git.paroli-project.org/python-elementary.git;protocol=http"

S = "${WORKDIR}/git"

do_stage() {         
	distutils_stage_all 
}  
