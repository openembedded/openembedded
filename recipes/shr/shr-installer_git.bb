DESCRIPTION = "EFL frontend for packagekit"
HOMEPAGE = "http://shr-project.org"
SHR_RELEASE ?= "shr"
LICENSE ?= "GPL"
RDEPENDS_${PN} = "python-elementary python-dbus python-core python-edbus packagekit"
SECTION = "x11/application"

SRCREV = "26c914bb438be450ba768b6131cbb52250ae55ae"
PV = "0.0.2+gitr${SRCPV}"
PR = "r1"

inherit setuptools

SRC_URI = "git://git.shr-project.org/repo/shr-installer.git;protocol=http"
S = "${WORKDIR}/git"

FILES_${PN} += "${prefix}/share/pixmaps"
FILES_${PN} += "${prefix}/share/applications"

