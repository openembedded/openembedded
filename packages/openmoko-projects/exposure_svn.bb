DESCRIPTION = "Exposure all devices on neo1973"
DEPENDS = "python-etk python-dbus"
RDEPENDS = "python-etk python-re python-codecs python-dbus"
PV = "0.0.1+svnr${SRCREV}"
PR = "r2"

S = "${WORKDIR}/${PN}"

inherit setuptools
SRC_URI = "svn://svn.projects.openmoko.org/svnroot;module=exposure;proto=http"


PACKAGES = "${PN}"

FILES_${PN} += "${prefix}/share/*"
