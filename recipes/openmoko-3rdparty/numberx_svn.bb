DESCRIPTION = "NumberX is a mathematical puzzle game that will challenge your mental math abilities! "
HOMEPAGE = "http://code.google.com/p/numberx/"
LICENSE = "GPLv3"
AUTHOR = "Valéry Febvre <vfebvre@easter-eggs.com>"
SECTION = "x11/applications"
PRIORITY = "optional"
DEPENDS = "python-native"

SRCREV = "4"
PV = "1.0.0+svnr${SRCPV}"

S = "${WORKDIR}/trunk"

PACKAGE_ARCH = "all"

SRC_URI = "svn://numberx.googlecode.com/svn;module=trunk;proto=http"

inherit distutils

RDEPENDS += "python-math python-elementary" 

FILES_${PN} += "${datadir}"
