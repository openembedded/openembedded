DESCRIPTION = "Python bindings to the Lightweight media scanner"
SECTION = "devel/python"
HOMEPAGE = "http://lms.garage.maemo.org/"
AUTHOR = "Gustavo Barbieri"
LICENSE = "LGPL"
DEPENDS = "lightmediascanner python-cython-native"
PV = "0.1.0+svnr${SRCREV}"
PE = "1"

SRC_URI = "svn://garage.maemo.org/svn/lms/;module=python-lightmediascanner;proto=https"
S = "${WORKDIR}/python-lightmediascanner"

inherit distutils
