require python-efl.inc
SRCREV = "${EFL_SRCREV}"
DEPENDS += "elementary"
RDEPENDS += "python-evas python-ecore python-edje" 
PV = "0.1+svnr${SRCPV}"
PR = "ml0"

do_stage() {         
	distutils_stage_all 
}  
