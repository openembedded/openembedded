DESCRIPTION = "Store knowledge in form of questions and answers and train them."
HOMEPAGE = "http://code.google.com/p/ebrainy/"
AUTHOR = "quickdev"
LICENSE = "GPL"
SECTION = "e/apps"
RDEPENDS = "elementary sqlite3 python-sqlalchemy python-mysqldb python-netserver"

PV = "0.0.1+svnr${SRCPV}"
PR = "r1"
SRCREV = "21"
SRC_URI = "svn://ebrainy.googlecode.com/svn/trunk;module=.;proto=http"
S = "${WORKDIR}"

inherit distutils
FILES_${PN} += "${datadir}/applications/ebrainy.desktop"

