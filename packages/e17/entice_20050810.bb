DESCRIPTION = "Entice is a picture viewer"
SECTION = "e/apps"
# can also depend on GIMP for editing
DEPENDS = "virtual/evas edb virtual/ecore edje"
LICENSE = "MIT"
HOMEPAGE = "http://www.enlightenment.org"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
CVSDATE = "${PV}"
PR = "r0"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/apps/entice"
S = "${WORKDIR}/entice"

inherit autotools

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} /etc/* /usr/sbin/*"

