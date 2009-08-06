DESCRIPTION = "Test scripts for freesmartphone.org opimd interface"
HOMEPAGE = "http://freesmartphone.org"
LICENSE ?= "GPL"
SECTION = "x11/application"
PV = "0.0.2+gitr${SRCREV}"
PR = "r0"

inherit setuptools

SRC_URI = "git://git.shr-project.org/repo/opimd-utils.git;protocol=http"
S = "${WORKDIR}/git"

RDEPENDS = "\
  python-elementary \
  python-edbus \
  python-codecs \
  python-shell \
  \
  shr-settings \
  shr-theme \
  frameworkd \
  pyphonelog \
"

FILES_${PN} += "${sysconfdir}/X11/Xsession.d/89opimd-notifier"
FILES_${PN} += "${prefix}/share/applications/"
FILES_${PN} += "${prefix}/share/pixmaps/opimd-utils/"
