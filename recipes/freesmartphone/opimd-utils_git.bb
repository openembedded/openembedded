DESCRIPTION = "Test scripts for freesmartphone.org opimd interface"
HOMEPAGE = "http://freesmartphone.org"
SHR_RELEASE ?= "shr"
LICENSE ?= "GPL"
RDEPENDS = "python-elementary python-dbus python-codecs python-shell python python-core python-edbus shr-settings frameworkd pyphonelog shr-theme"
SECTION = "x11/application"
PV = "0.0.2+gitr${SRCPV}"
PR = "r1"

inherit setuptools

PACKAGES =+ "\
  ${PN}-cli \
  ${PN}-data \
"

RDEPENDS_${PN} = "\
  ${PN}-data \
"

RRECOMMENDS_${PN} = "\
  ${PN}-cli \
"

PACKAGE_ARCH_${PN}-cli = "all"
PACKAGE_ARCH_${PN}-data = "all"

SRC_URI = "git://git.shr-project.org/repo/opimd-utils.git;protocol=http"
S = "${WORKDIR}/git"
FILES_${PN} += "${sysconfdir}/X11/Xsession.d/89opimd-notifier"
FILES_${PN} += "${prefix}/share/applications/"
FILES_${PN}-data += "${prefix}/share/pixmaps/opimd-utils/"
FILES_${PN}-cli = "${prefix}/bin/opimd-cli"
