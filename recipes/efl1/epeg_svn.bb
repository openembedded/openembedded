DESCRIPTION = "Epeg is a small library for handling thumbnails."
LICENSE = "MIT"
DEPENDS = "jpeg"
PV = "0.9.0+svnr${SRCREV}"
PR = "r2"

inherit efl

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/OLD;module=epeg;proto=http"
