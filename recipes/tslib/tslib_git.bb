SRC_URI = "git://github.com/kergoth/tslib.git;protocol=git"
S = "${WORKDIR}/git"
SRCREV = "43abb4bcac12bed4dfa7"
PV = "1.0+gitr${SRCPV}"
PR = "${INC_PR}.1"

DEFAULT_PREFERENCE = "-1"

include tslib.inc
