SECTION = "libs"
LICENSE = "MIT"
PV = "0.0cvs${CVSDATE}"
DEPENDS = "jpeg"
DESCRIPTION = "Epeg is a small library for handling thumbnails."

SRC_URI = "cvs://anonymous:@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/libs/epeg \
	   file://dirs.patch;patch=1"
S = "${WORKDIR}/epeg"

inherit autotools 
