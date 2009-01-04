require python-efl.inc
DEPENDS += "elementary"
RDEPENDS += "python-evas python-ecore python-edje" 
PV = "0.0.0+svnr${SRCREV}"
PR = "r0"

do_stage() {         
	distutils_stage_all 
}  
