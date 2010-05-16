PV = "0.0.1.27+cvs${SRCDATE}"

SRC_URI = "cvs://anonymous@linknx.cvs.sourceforge.net/cvsroot/linknx;module=linknx;method=pserver "
S = "${WORKDIR}/linknx/linknx"

require linknx.inc
