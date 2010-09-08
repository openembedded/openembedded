SRC_URI = "git://github.com/kergoth/tslib.git;protocol=git"
S = "${WORKDIR}/git"
SRCREV = "d9ff92d46a1e17361ac1"
PV = "1.0+gitr${SRCPV}"
PR = "${INC_PR}.1"

DEFAULT_PREFERENCE = "-1"

include tslib.inc
