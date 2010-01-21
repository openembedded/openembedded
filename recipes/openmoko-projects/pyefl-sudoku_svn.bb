DESCRIPTION = "Sudoku is a logic-based number-placement puzzle. The objective is to fill a 9×9 grid so that each column, each row, and each of the nine 3×3 boxes (also called blocks or regions) contains the digits from 1 to 9 only one time each."
HOMEPAGE = "http://pyefl-sudoku.projects.openmoko.org/"
SECTION = "openmoko/applications"
LICENSE = "GPL"
DEPENDS = "python-evas python-edje python-ecore"
RDEPENDS = "python-evas python-edje python-ecore"
PV = "0.0.2+svnr${SRCPV}"
PR = "r3"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/;module=pyefl-sudoku;proto=http"

S = "${WORKDIR}/pyefl-sudoku"

inherit setuptools

PACKAGES = "${PN}"

FILES_${PN} += "${prefix}/share/*"
