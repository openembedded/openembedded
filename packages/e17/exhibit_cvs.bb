DESCRIPTION = "Exhibit is the ETK picture viewer"
DEPENDS = "evas ecore edje etk epsilon engrave"
LICENSE = "MIT"
PV = "0.0.0+cvs${SRCDATE}"
PR = "r0"

inherit e

SRC_URI = "cvs://anonymous@anoncvs.enlightenment.org/var/cvs/e;module=e17/apps/exhibit"
S = "${WORKDIR}/${PN}"
