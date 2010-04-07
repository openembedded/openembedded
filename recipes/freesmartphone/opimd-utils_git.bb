DESCRIPTION = "Test scripts for freesmartphone.org opimd interface"
HOMEPAGE = "http://freesmartphone.org"
SHR_RELEASE ?= "shr"
LICENSE ?= "GPL"
RDEPENDS = "python-elementary python-dbus python-codecs python-shell python python-core python-edbus frameworkd"
SECTION = "x11/application"
SRCREV = "1872cdebe1209123710259e25cb8c8b47a627112"
PV = "0.0.3+gitr${SRCREV}"
PR = "r0"

inherit setuptools

PACKAGES =+ "\
  ${PN}-cli \
  ${PN}-notes \
  ${PN}-data \
"

RDEPENDS_${PN} = "\
  ${PN}-data \
  shr-settings \
  pyphonelog \
  shr-theme \
"

RDEPENDS_${PN}-notes = "\
  ${PN}-data \
"

RRECOMMENDS_${PN} = "\
  ${PN}-notes \
  ${PN}-cli \
"

PACKAGE_ARCH_${PN}-cli = "all"
PACKAGE_ARCH_${PN}-data = "all"
PACKAGE_ARCH_${PN}-notes = "all"

SRC_URI = "git://git.shr-project.org/repo/opimd-utils.git;protocol=http"
S = "${WORKDIR}/git"
FILES_${PN} += "${sysconfdir}/X11/Xsession.d/89opimd-notifier"
FILES_${PN} += "${prefix}/share/applications/"
FILES_${PN} += "${prefix}/share/pixmaps/"
FILES_${PN}-data += "${prefix}/share/pixmaps/opimd-utils/"
FILES_${PN}-cli += "${prefix}/bin/opimd-cli"
FILES_${PN}-notes += "${prefix}/bin/opimd-notes"
FILES_${PN}-notes += "${prefix}/share/pixmaps/opimd-notes.png"
FILES_${PN}-notes += "${prefix}/share/applications/opimd-notes.desktop"
