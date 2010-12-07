DESCRIPTION = "PyPhonelog is a phonelog gui that connects to the shr daemon/a custom daemon"
HOMEPAGE = "http://wiki.openmoko.org/wiki/PyPhonelog"
SECTION = "x11/applications"
LICENSE = "GPLv2"
SRCNAME = "pyphonelog"
RDEPENDS_${PN} += "python python-pygtk python-sqlite3 python-phoneutils"

inherit distutils

S = "${WORKDIR}/git"
SRCREV = "d22159060470d2f429d4e8b9ba1dc3096aa5d099"
PE = "1"
PV = "0.17.0+gitr${SRCPV}"
PR = "r1"
SRC_URI = "git://git.shr-project.org/repo/pyphonelog.git;protocol=http"
FILES_${PN} += "${datadir}/applications/phonelog.desktop \
		${datadir}/phonelog/ \
		${datadir}/pixmaps/phonelog.png"
