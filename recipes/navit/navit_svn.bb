require navit.inc

SRCREV = "3931"
PV = "0.1.99+svnr${SRCPV}"
PR = "${INC_PR}.12"

S = "${WORKDIR}/navit"
SRC_URI += "svn://anonymous@navit.svn.sourceforge.net/svnroot/navit/trunk;module=navit;proto=https "
