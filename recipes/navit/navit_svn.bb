require navit.inc

SRCREV = "3358"
PV = "0.1.99+svnr${SRCPV}"
PR = "${INC_PR}.8"

S = "${WORKDIR}/navit"
SRC_URI += "svn://anonymous@navit.svn.sourceforge.net/svnroot/navit/trunk;module=navit;proto=https "
