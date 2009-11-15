DESCRIPTION = "A Python extension for wpa_supplicant/hostapd control interface access"
SECTION = "devel/python"
LICENSE = "GPLv2"
HOMEPAGE = "http://projects.otaku42.de/wiki/PythonWpaCtrl"

inherit distutils

SRCREV = "383"
SRC_URI = "svn://svn.otaku42.de;module=python-wpactrl;proto=http"
S = "${WORKDIR}/python-wpactrl/trunk"
PV = "1.0.1+svnr${SRCPV}"

