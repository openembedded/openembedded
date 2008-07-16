DESCRIPTION = "pythonEFL-sudoku puzzle game"
HOMEPAGE = "http://pyefl-sudoku.projects.openmoko.org/"
SECTION = "openmoko/applications"
LICENSE = "GPL"
DEPENDS = "python-evas python-edje python-ecore"
RDEPENDS = "python-evas python-edje python-ecore"
PV = "0.0.2+svnr${SRCREV}"
PR = "r0"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/;module=pyefl-sudoku;proto=http"

S = "${WORKDIR}/pyefl-sudoku"

inherit setuptools

PACKAGES = "${PN}"

FILES_${PN} += "${prefix}/share/*"

PKG_TAGS_${PN} = "group::games"
