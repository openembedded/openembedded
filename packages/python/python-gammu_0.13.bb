DESCRIPTION = "Python bindings for the gammu GSM phone communication library."
HOMEPAGE = "http://cihar.com/gammu/python"
SECTION = "devel/python"
DEPENDS = "gammu"
LICENSE = "GPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PR = "r0"

SRC_URI = "http://cihar.com/gammu/python/python-gammu-${PV}.tar.bz2"

inherit distutils

