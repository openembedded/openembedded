DESCRIPTION = "Edb is the Enlightenment database library"
LICENSE = "MIT BSD"
DEPENDS = "zlib"
PV = "1.0.5.050+svnr${SRCPV}"
PR = "r1"

inherit efl

SRC_URI = "svn://svn.enlightenment.org/svn/e/OLD;module=edb;proto=http"
