require python-efl.inc
DEPENDS += "etk python-evas python-ecore"
RDEPENDS += "python-evas python-ecore python-edje python-numeric python-math etk-themes" 
PV = "0.1.1+svnr${SRCPV}"
PR = "ml1"

SRC_URI = "svn://svn.enlightenment.org/svn/e/OLD/BINDINGS/python;module=${PN};proto=http"

do_stage() {         
	distutils_stage_all 
}  
