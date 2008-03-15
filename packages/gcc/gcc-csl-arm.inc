require gcc-common.inc
BINV = "3.4.4"
PV = "3.4.4+csl-arm-${SRCDATE}"

FILESDIR = "${FILE_DIRNAME}/gcc-csl-arm"
DEFAULT_PREFERENCE = "-1"

SRC_URI = "cvs://anonymous@cvs.savannah.gnu.org/cvsroot/gcc;method=pserver;tag=csl-arm-branch;module=gcc;date=${SRCDATE} \
	   file://gcc34-arm-tune.patch;patch=1"

require gcc3-build.inc

S = "${WORKDIR}/gcc"

