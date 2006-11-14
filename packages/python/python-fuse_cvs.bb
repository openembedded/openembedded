DESCRIPTION = "FUSE Python bindings."
LICENSE = "GPLv2"

PV = "0.0+cvs${SRCDATE}"

SRC_URI = "cvs://anonymous@fuse.cvs.sourceforge.net/cvsroot/fuse;module=python"

inherit distutils

S = "${WORKDIR}/python"

