DESCRIPTION = "Entrace is the Enlightenment login manager for X11"
SECTION = "e/apps"
LICENSE = "MIT"
DEPENDS = "ecore-x11 edje-native embryo-native esmart"
HOMEPAGE = "http://www.enlightenment.org"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
CVSDATE = "${PV}"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/apps/entrance \
           file://longer-sleep.patch;patch=1"
S = "${WORKDIR}/entrance"

inherit autotools

# EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc"

PARALLEL_MAKE = ""

