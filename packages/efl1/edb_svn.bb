DESCRIPTION = "Edb is the Enlightenment database library"
LICENSE = "MIT BSD"
DEPENDS = "zlib"
PV = "1.0.5.043+svnr${SRCREV}"
PR = "r2"

inherit efl

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/OLD;module=edb;proto=http"
