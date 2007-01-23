DESCRIPTION = "Tin is a powerful text mode news reader."
SECTION = "console/network"
DEPENDS = "ncurses libpcre"
LICENSE = "BSD"

inherit autotools 

EXTRA_OECONF = "--with-screen=ncurses --with-pcre=${STAGING_LIBDIR}/.."
