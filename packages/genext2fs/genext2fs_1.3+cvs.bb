include genext2fs.inc

PV_append = "${CVSDATE}"
PR = "r2"
FILESPATH = "${FILE_DIRNAME}/genext2fs-1.3+cvs:${FILE_DIRNAME}/genext2fs:${FILE_DIRNAME}/files"
SRC_URI = "cvs://anonymous:@cvs.sourceforge.net/cvsroot/genext2fs;module=genext2fs \
	   file://bytes_per_inode.patch;patch=1"
S = "${WORKDIR}/genext2fs"

inherit autotools
