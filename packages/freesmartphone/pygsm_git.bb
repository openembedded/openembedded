DESCRIPTION = "Python support library for GSM 07.07 / GSM 07.05 daemons"
AUTHOR = "Michael Dietrich"
SECTION = "console/network"
DEPENDS = "python-cython-native python-pyrex-native"
LICENSE = "GPL"
PV = "0.0.0+gitr${SRCREV}"
PR = "r0"

inherit distutils

SRC_URI = "${FREESMARTPHONE_GIT}/pygsm.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

RDEPENDS_${PN} += "\
  python-dbus \
  python-pygobject \
  python-syslog \
"
