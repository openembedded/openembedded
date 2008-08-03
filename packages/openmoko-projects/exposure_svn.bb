DESCRIPTION = "Exposure all devices on neo1973"
DEPENDS = "python-etk python-edbus"
RDEPENDS = "python-etk python-re python-codecs python-edbus python-pyxdg"
PV = "0.0.1+svnr${SRCREV}"
PR = "r2.04"

S = "${WORKDIR}/trunk"

inherit setuptools
SRC_URI = "svn://svn.projects.openmoko.org/svnroot/exposure;module=trunk;proto=http \
           file://setup-r62.diff;patch=1;pnum=0"


PACKAGES = "${PN}"
FILES_${PN} += "${prefix}/share/* ${sysconfdir}/X11/Xsession.d/*"
