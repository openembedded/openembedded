require python-efl.inc
DEPENDS += "etk"
RDEPENDS += "python-evas python-ecore python-edje python-numeric python-math etk-themes" 
PV = "0.3.0+svnr${SRCREV}"
PR = "r0"

do_stage() {         
	distutils_stage_all 
}  
