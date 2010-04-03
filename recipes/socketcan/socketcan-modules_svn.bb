DESCRIPTION = "Socketcan kernel modules"
HOMEPAGE = "http://developer.berlios.de/projects/socketcan/"
SECTION = "kernel/modules"
LICENSE = "GPL"
DEPENDS = "virtual/kernel"
SRCREV = "917"
PV = "0.0+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://svn.berlios.de/socketcan;module=trunk;proto=svn"

S = "${WORKDIR}/trunk/kernel/2.6"

inherit module

