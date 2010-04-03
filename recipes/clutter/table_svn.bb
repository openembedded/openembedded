require table.inc

SRCREV = "2191"
PV = "0.3.0+svnr${SRCPV}"

SRC_URI = "svn://svn.o-hand.com/repos/clutter/trunk/toys;module=table;proto=http \
           file://fixes.patch;patch=1"

S = "${WORKDIR}/table"


