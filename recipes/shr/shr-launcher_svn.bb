DESCRIPTION = "shr-launcher is a home app/launcher for openmoko phones"
HOMEPAGE = "http://code.google.com/p/shr-launcher/"
AUTHOR = "cchandel"
LICENSE = "GPLv2"
SECTION = "e/apps"
DEPENDS = "elementary eina edbus"

PV = "0.0.1+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://shr-launcher.googlecode.com/svn/trunk;module=.;proto=http"

do_configure_prepend() {
  rm -f ${S}/config.log
  rm -f ${S}/config.status
}

S = "${WORKDIR}"

inherit autotools

