DESCRIPTION = "An e17 module and a python app for the SHR first run wizard"
HOMEPAGE = "http://shr-project.org"
LICENSE = "GPL"
DEPENDS = "e-wm"
RDEPENDS_${PN} = "python-elementary shr-settings python-phoneutils e-wm python-dbus python-edbus"
SECTION = "x11/application"
SRCREV = "94deff37e2f17dce0e7b4f51e16ee8e5981de58a"
PV = "0.0.0+gitr${SRCPV}"
PR = "r9"

inherit autotools

SRC_URI = "git://git.shr-project.org/repo/shr-wizard.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

FILES_${PN} += "${libdir}/enlightenment/modules/wizard/*/page_900.so"


