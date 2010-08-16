DESCRIPTION = "An e17 module and a python app for the SHR first run wizard"
HOMEPAGE = "http://shr-project.org"
LICENSE = "GPL"
DEPENDS = "e-wm"
RDEPENDS_${PN} = "python-elementary shr-settings python-phoneutils e-wm python-dbus python-edbus"
SECTION = "x11/application"
SRCREV = "b04c841861b0f293e1a9536592fd154efc662554"
PV = "0.0.0+gitr${SRCPV}"
PR = "r7"

inherit autotools

SRC_URI = "git://git.shr-project.org/repo/shr-wizard.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

FILES_${PN} += "${libdir}/enlightenment/modules/wizard/*/page_900.so"


