DESCRIPTION = "A classic Memory game for mobile devices"
HOMEPAGE = "http://code.google.com/p/minneo/"
LICENSE = "GPLv3"
AUTHOR = "Valéry Febvre <vfebvre@easter-eggs.com>"
SECTION = "x11/applications"
PRIORITY = "optional"

SRCREV = "4"
PV = "1.0.1+svnr${SRCPV}"

PACKAGE_ARCH = "all"

SRC_URI = "svn://minneo.googlecode.com/svn;module=trunk;proto=http"
S = "${WORKDIR}/trunk"

inherit distutils

FILES_${PN} += "${datadir}/minneo ${datadir}/applications/minneo.desktop ${datadir}/pixmaps/minneo.png"

RDEPENDS_${PN} += "python-audio python-pyalsaaudio python-elementary"
