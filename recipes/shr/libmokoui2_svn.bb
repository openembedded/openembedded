DESCRIPTION = "Set of UI widgets to ease development and integration with the OpenMoko phone environment."
SECTION = "x11/libs"
DEPENDS += " python gtk-doc libffi"
PV = "0.0.1+svnr${SRCREV}"
PR = "r0"
SRC_URI = "svn://svn.openmoko.org/trunk/src/target/OM-2007.2/libraries;module=${PN};proto=http"
S = "${WORKDIR}/${PN}"
inherit autotools

