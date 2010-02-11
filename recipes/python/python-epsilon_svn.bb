require python-efl.inc
DEPENDS += "epsilon python-ecore"
RDEPENDS += "python-ecore"

SRC_URI = "svn://svn.enlightenment.org/svn/e/OLD/BINDINGS/python;module=${PN};proto=http"
