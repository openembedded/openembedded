include quilt.inc

PR = "r1"
RSUGGESTS += "wiggle"
SRC_URI = "cvs://anoncvs:@savannah.nongnu.org/cvsroot/quilt;method=ext;module=quilt;tag=VER_0_37 \
	   file://install.patch;patch=1 \
	   file://nostrip.patch;patch=1 \
	   file://wiggle.patch;patch=1"
S = "${WORKDIR}/quilt"

inherit autotools gettext

include quilt-package.inc
