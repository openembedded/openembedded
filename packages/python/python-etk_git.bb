DESCRIPTION = "Python etk binding"
require python-efl.inc 
DEPENDS += "etk python-setuptools python-ecore python-cython python-edje" 
RDEPENDS += "etk python-cython python-evas python-ecore python-edje python-numeric python-math etk-themes" 
PR = "r0.01"  

SRC_URI = "git://staff.get-e.org/users/cmarcelo/python-etk.git;protocol=git"

S = "${WORKDIR}/git"

do_stage() {         
	distutils_stage_all 
}  
