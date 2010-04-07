DESCRIPTION = "EFL frontend for packagekit"
HOMEPAGE = "http://shr-project.org"
SHR_RELEASE ?= "shr"
LICENSE ?= "GPL"
RDEPENDS = "python-elementary python-dbus python-core python-edbus packagekit"
SECTION = "x11/application"

SRCREV = "8608816ea1a1ac14b6e9faaa3685dd2b6450e889"
PV = "0.0.2+gitr${SRCREV}"
PR = "r0"

inherit setuptools

SRC_URI = "git://git.shr-project.org/repo/shr-installer.git;protocol=http"
S = "${WORKDIR}/git"

FILES_${PN} += "${prefix}/share/pixmaps"
FILES_${PN} += "${prefix}/share/applications"

