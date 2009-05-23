DESCRIPTION = "todo list manager in EFL"
HOMEPAGE = "http://enotes.googlecode.com"
AUTHOR = "furester"
LICENSE = "GPL"
SECTION = "e/apps"
DEPENDS = "elementary evas sqlite3"

PV = "0.2.2+svnr${SRCREV}"
PR = "r0"
SRC_URI = "svn://enotes.googlecode.com/svn/trunk;module=.;proto=http"
S = "${WORKDIR}"

inherit autotools


