DESCRIPTION = "DirectFB Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "directfb"
SRCNAME = "pydirectfb"
PV = "0.0.0+cvs${SRCDATE}"
PR = "ml0"

SRC_URI = "cvs://anonymous@pydirectfb.cvs.sourceforge.net/cvsroot/pydirectfb;module=pydirectfb \
           file://fix-directfb-detection.patch;patch=1"
S = "${WORKDIR}/${SRCNAME}"

inherit distutils
	
