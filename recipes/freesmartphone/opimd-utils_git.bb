DESCRIPTION = "Test scripts for freesmartphone.org opimd interface"
HOMEPAGE = "http://freesmartphone.org"
SHR_RELEASE ?= "shr"
LICENSE ?= "GPL"
RDEPENDS = "python-elementary python-dbus python-codecs python-shell python python-core python-edbus shr-settings frameworkd pyphonelog shr-theme"
SECTION = "x11/application"
PV = "0.0.1+gitr${SRCPV}"
PR = "r4"

inherit setuptools

SRC_URI = "git://git.shr-project.org/opimd-utils.git;protocol=http"
S = "${WORKDIR}/git"
FILES_${PN} += "${sysconfdir}/X11/Xsession.d/89opimd-notifier"
FILES_${PN} += "${prefix}/share/applications/"
FILES_${PN} += "${prefix}/share/pixmaps/opimd-utils/"
