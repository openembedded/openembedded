DESCRIPTION = "Diversity Radar is a GPS location based communicative application"
HOMEPAGE = "http://diversity.projects.openmoko.org/"
SECTION = "openmoko/applications"
LICENSE = "GPL"
DEPENDS = "python-evas python-edje python-ecore python-edbus python-dbus python-etk"
RDEPENDS_${PN} = "diversity-daemon"
PV = "0.0.4+svnr${SRCPV}"
PR = "r0.02"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/diversity/toys;module=diversity-radar;proto=http"

S = "${WORKDIR}/${PN}"

inherit setuptools

FILES_${PN} += "${prefix}/share/*"
