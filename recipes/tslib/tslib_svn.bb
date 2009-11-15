SRC_URI = "svn://svn.berlios.de/tslib/trunk;module=tslib"
S = "${WORKDIR}/tslib"
PV = "1.0+svnr${SRCPV}"
PR = "${INC_PR}.1"

DEFAULT_PREFERENCE = "-1"

include tslib.inc
