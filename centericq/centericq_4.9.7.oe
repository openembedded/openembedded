DEPENDS = "openssl ncurses"
DESCRIPTION = "An ncurses-based IM client for ICQ2000, Yahoo!, \
AIM, IRC, Jabber and LiveJournal"
SECTION = "console/network"
LICENSE = "GPL" 

SRC_URI = "http://centericq.de/archive/source/releases/centericq-${PV}.tar.bz2 \
	   file://configure.patch;patch=1 \
	   file://m4.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-ssl --with-openssl=${STAGING_LIBDIR}/.."
