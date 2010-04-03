require kismet.inc

DEFAULT_PREFERENCE = "-1"

SRCREV = "2285"
PV = "2007-10-R1+svnr${SRCPV}"
PR = "r2"

SRC_URI = "svn://svn.kismetwireless.net/code/;module=trunk;proto=http"

S = "${WORKDIR}/trunk"
