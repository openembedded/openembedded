require genext2fs.inc

PV_append = "${SRCDATE}"
PR = "r3"
FILESPATHPKG =. "genext2fs-1.3+cvs:"
SRC_URI = "cvs://anonymous:@genext2fs.cvs.sourceforge.net/cvsroot/genext2fs;module=genext2fs"
S = "${WORKDIR}/genext2fs"

inherit autotools
