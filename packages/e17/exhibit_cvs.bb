DESCRIPTION = "Exhibit is the ETK picture viewer"
DEPENDS = "evas ecore epsilon edje eet etk efreet"
LICENSE = "MIT"
PV = "0.0.0+cvs${SRCDATE}"
PR = "r0"

inherit e

SRC_URI = "${E_CVS};module=e17/apps/exhibit"
S = "${WORKDIR}/${PN}"
