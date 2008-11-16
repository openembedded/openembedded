DESCRIPTION = "Accelerometer gestures"
HOMEPAGE = "http://code.google.com/p/accelges/"
AUTHOR = "Paul V. Borza"
LICENSE = "GPL"
DEPENDS = "libnotify"
PV = "0.2+svnr${SRCREV}"
PR = "r1"
PE = "1"

SRC_URI = "svn://accelges.googlecode.com/svn/;module=trunk;proto=http"
S = "${WORKDIR}/trunk"

inherit autotools

# FIXME increase packaging granularity
FILES_${PN} += "${datadir}"

