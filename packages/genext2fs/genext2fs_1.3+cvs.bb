include genext2fs.inc

PV_append = "${SRCDATE}"
PR = "r3"
FILESPATH = "${FILE_DIRNAME}/genext2fs-1.3+cvs:${FILE_DIRNAME}/genext2fs:${FILE_DIRNAME}/files"
SRC_URI = "cvs://anonymous:@cvs.sourceforge.net/cvsroot/genext2fs;module=genext2fs"
S = "${WORKDIR}/genext2fs"

inherit autotools
