DESCRIPTION = "tasks app for openmoko phones based on elementary"
HOMEPAGE = "http://code.google.com/p/e-tasks/"
AUTHOR = "cchandel"
LICENSE = "GPLv2"
SECTION = "e/apps"
#DEPENDS = "elementary eina edbus"

PV = "0.0.1+svnr${SRCPV}"
PR = "r0"

SRC_URI = "svn://e-tasks.googlecode.com/svn/trunk;module=.;proto=http"
S = "${WORKDIR}"

inherit autotools

