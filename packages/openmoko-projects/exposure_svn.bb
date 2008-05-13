AUTHOR = "Willie <willie@openmoko.com>"
DESCRIPTION = "Exposure all devices on neo1973"
DEPENDS = "python-etk"
RDEPENDS = "python-etk python-re python-codecs"
PV = "0.0.1+svnr${SRCREV}"
SRCREV = ${AUTOREV}
PR = "r0"

S = ${WORKDIR}/${PN}

inherit setuptools
SRC_URI = "svn://svn.projects.openmoko.org/svnroot;module=exposure;proto=http"


PACKAGES = "${PN}"

FILES_${PN} += "${prefix}/share/*"
