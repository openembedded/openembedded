DESCRIPTION = "FUSE Python bindings."
LICENSE = "GPLv2"
DEPENDS = "fuse"

PV = "0.0+cvs${SRCDATE}"

PR = "r1"

SRC_URI = "cvs://anonymous@fuse.cvs.sourceforge.net/cvsroot/fuse;module=python"

inherit distutils

S = "${WORKDIR}/python"

FILES_${PN}-dbg += "${libdir}/python*/site-packages/fuseparts/.debu*"
