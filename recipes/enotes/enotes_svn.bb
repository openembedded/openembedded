DESCRIPTION = "todo list manager in EFL"
HOMEPAGE = "http://enotes.googlecode.com"
AUTHOR = "furester"
LICENSE = "GPL"
SECTION = "e/apps"
DEPENDS = "elementary evas sqlite3"

SRCREV = "19"
PV = "0.2.2+svnr${SRCPV}"
PR = "r2"
SRC_URI = "svn://enotes.googlecode.com/svn/trunk;module=.;proto=http"
S = "${WORKDIR}"

inherit autotools


