DESCRIPTION = "Enhance translates between glade .xml files and ETK"
LICENSE = "MIT"
DEPENDS = "exml"
PV = "0.0.1+svnr${SRCPV}"
PR = "r1"
SRCREV = "${EFL_SRCREV}"

inherit efl

SRC_URI = "svn://svn.enlightenment.org/svn/e/OLD;module=${PN};proto=http"
