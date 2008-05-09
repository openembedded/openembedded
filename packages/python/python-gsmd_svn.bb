DESCRIPTION = "Python bindings for the libgsmd"
SRCNAME = "python-gsmd"
AUTHOR = "Sudharshan S"
SECTION = "devel/python"
LICENSE = "LGPL"
DEPENDS = "libgsmd"
PV = "0.02+svnr${SRCREV}"
PR = "r0"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/python-openmoko/trunk;module=python-gsmd;proto=http"
S = "${WORKDIR}/python-gsmd"

inherit distutils
