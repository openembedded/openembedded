DESCRIPTION = "Rdesktop rdp client for X"
DEPENDS = "virtual/libx11 openssl"
HOMEPAGE = "http://www.rdesktop.org"
SECTION = "x11/network"
LICENSE = "GPL"
PV = "1.5.0"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/rdesktop/rdesktop-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--with-openssl=${STAGING_LIBDIR}/.. "
