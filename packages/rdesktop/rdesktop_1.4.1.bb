DESCRIPTION = "Rdesktop rdp client for X"
DEPENDS = "x11 openssl"
HOMEPAGE = "http://www.rdesktop.org"
SECTION = "x11/network"
MAINTAINER = "Adrian Davey <ade@beth2.org>"
LICENSE = "GPL"
PV = "1.4.1"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/rdesktop/rdesktop-${PV}.tar.gz \
	file://strip.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-openssl=${STAGING_LIBDIR}/.. "
