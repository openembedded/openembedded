DESCRIPTION = "An ncurses-based IM client for ICQ2000, Yahoo!, AIM, IRC, Jabber and LiveJournal"
HOMEPAGE = "http://www.centerim.org"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "openssl ncurses"

inherit autotools

SRC_URI = "http://www.centerim.org/download/releases/centerim-4.22.5.tar.gz "

EXTRA_OECONF = "--with-ssl --with-openssl=${STAGING_LIBDIR}/.."
