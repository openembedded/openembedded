DESCRIPTION = "shr-launcher is a home app/launcher for openmoko phones"
HOMEPAGE = "http://code.google.com/p/shr-launcher/"
AUTHOR = "cchandel"
LICENSE = "GPLv2"
SECTION = "e/apps"
DEPENDS = "elementary eina edbus"

PV = "0.0.1+svnr${SRCREV}"
PR = "r0"

SRC_URI = "svn://shr-launcher.googlecode.com/svn/trunk;module=.;proto=http"
S = "${WORKDIR}"

inherit autotools

