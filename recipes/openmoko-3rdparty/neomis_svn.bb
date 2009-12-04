DESCRIPTION = "A computer version of the well-known electronic game named Simon"
HOMEPAGE = "http://code.google.com/p/neomis/"
LICENSE = "GPLv3"
AUTHOR = "Valéry Febvre <vfebvre@easter-eggs.com>"
SECTION = "x11/applications"
PRIORITY = "optional"
DEPENDS = "python-native"

PV = "1.1.0+svnr${SRCPV}"

S = "${WORKDIR}/trunk"

PACKAGE_ARCH = "all"

SRC_URI = "svn://neomis.googlecode.com/svn;module=trunk;proto=http"

inherit distutils

FILES_${PN} += "${datadir}/neomis ${datadir}/applications/neomis.desktop ${datadir}/pixmaps"

RDEPENDS += "python-audio python-pyalsaaudio python-elementary" 
