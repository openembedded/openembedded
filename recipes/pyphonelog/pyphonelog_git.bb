DESCRIPTION = "PyPhonelog is a phonelog gui that connects to the shr daemon/a custom daemon"
HOMEPAGE = "http://wiki.openmoko.org/wiki/PyPhonelog"
SECTION = "x11/applications"
LICENSE = "GPLv2"
SRCNAME = "pyphonelog"
RDEPENDS += "python python-pygtk python-sqlite3 python-phoneutils"

inherit distutils

S = "${WORKDIR}/git"
SRCREV = "4f0c2142dc442f2f43b80a101e5f297fee85219a"
PV = "0.17.0+gitr${SRCPV}"
PR = "r0"
SRC_URI = "git://shr.bearstech.com/repo/pyphonelog.git;protocol=http"
FILES_${PN} += "${datadir}/applications/phonelog.desktop \
		${datadir}/phonelog/ \
		${datadir}/pixmaps/phonelog.png"
