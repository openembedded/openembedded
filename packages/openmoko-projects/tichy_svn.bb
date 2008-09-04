DESCRIPTION = "Python applets manager"
SECTION = "x11"
LICENSE = "GPL"
DEPENDS = "python-pygame"
PV = "0.1+svnr${SRCREV}"
PR = "r0"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot;module=tichy;proto=http"
S = "${WORKDIR}/tichy"

inherit distutils

FILES_${PN} += "${datadir}"
RDEPENDS_${PN} += "python-pygame"
