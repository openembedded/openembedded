DESCRIPTION = "Rdesktop rdp client for X"
DEPENDS = "virtual/libx11 openssl"
HOMEPAGE = "http://www.rdesktop.org"
SECTION = "x11/network"
LICENSE = "GPL"
PV = "1.5.0+cvs${SRCDATE}"
PR = "r3"
DEFAULT_PREFERENCE = "-1"
SRC_URI = "cvs://anonymous@rdesktop.cvs.sourceforge.net/cvsroot/rdesktop;module=rdesktop"
S = "${WORKDIR}/rdesktop"

inherit autotools

EXTRA_OECONF = "--with-openssl=${STAGING_LIBDIR}/.. "

