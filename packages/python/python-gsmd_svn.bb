DESCRIPTION = "Python bindings for the libgsmd"
SRCNAME = "python-gsmd"
AUTHOR = "Sudharshan S"
SECTION = "devel/python"
LICENSE = "LGPL"
DEPENDS = "libgsmd"
PV = "0.02+svnr${SRCREV}"
PR = "r1"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/python-openmoko;module=python-gsmd;proto=http"
S = "${WORKDIR}/python-gsmd"

SRCREV_pn-python-gsmd ?= "${AUTOREV}"

inherit distutils
