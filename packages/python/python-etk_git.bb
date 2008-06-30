require python-efl.inc
DEPENDS += "etk"
RDEPENDS += "python-evas python-ecore python-edje python-numeric python-math etk-themes" 
PV = "0.0.0+git${SRCREV}"
PR = "r1"  

SRC_URI = "git://staff.get-e.org/users/cmarcelo/python-etk.git;protocol=git"
S = "${WORKDIR}/git"

do_stage() {         
	distutils_stage_all 
}  
