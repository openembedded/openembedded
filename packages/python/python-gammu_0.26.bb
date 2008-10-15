DESCRIPTION = "Python bindings for the gammu GSM phone communication library."
HOMEPAGE = "http://cihar.com/gammu/python"
SECTION = "devel/python"
DEPENDS = "gammu"
LICENSE = "GPL"
PR = "ml0"

SRC_URI = "http://dl.cihar.com/python-gammu/latest/python-gammu-${PV}.tar.bz2"

inherit distutils
