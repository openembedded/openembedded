DESCRIPTION = "Rdesktop rdp client for X"
DEPENDS = "x11 openssl"
HOMEPAGE = "http://www.rdesktop.org"
SECTION = "x11/network"
MAINTAINER = "Adrian Davey <ade@beth2.org>"
LICENSE = "GPL"
PV = "1.3.1cvs${CVSDATE}"
PR = "r1"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/rdesktop;module=rdesktop"
S = "${WORKDIR}/rdesktop"

inherit autotools

EXTRA_OECONF = "--with-openssl=${STAGING_LIBDIR}/.. "

