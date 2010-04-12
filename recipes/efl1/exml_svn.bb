DESCRIPTION = "Exml is a generic XML parser wrapper."
LICENSE = "MIT"
DEPENDS = "libxml2 libxslt ecore"
PV = "0.1.1+svnr${SRCPV}"
PR = "r2"
SRCREV = "${EFL_SRCREV}"

inherit efl

SRC_URI = "svn://svn.enlightenment.org/svn/e/BROKEN;module=${PN};proto=http"
