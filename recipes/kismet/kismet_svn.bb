require kismet.inc

DEFAULT_PREFERENCE = "-1"

SRCREV = "2285"
PV = "2007-10-R1+svnr${SRCPV}"
PR = "r2"

SRC_URI = "svn://www.kismetwireless.net/code/svn/;module=trunk;proto=https"

S = "${WORKDIR}/trunk"
