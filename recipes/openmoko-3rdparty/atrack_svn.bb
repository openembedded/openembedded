DESCRIPTION = "Embedded linux APRS tool"
HOMEPAGE = "http://code.google.com/p/atrack/"
LICENSE = "GPLv3"
AUTHOR = "Petr Vanek <vanous@penguin.cz>"
SECTION = "x11/applications"
PRIORITY = "optional"

SRCREV = "128"
PV = "0.0.81+svnr${SRCPV}"

PACKAGE_ARCH = "all"

SRC_URI = "svn://atrack.googlecode.com/svn;module=trunk;proto=http"
S = "${WORKDIR}/trunk"

inherit distutils

FILES_${PN} += "${datadir}/atrack ${datadir}/applications/atrack.desktop ${datadir}/pixmaps"

RDEPENDS_${PN} += "python-netclient python-elementary"
