DESCRIPTION = "Tin is a powerful text mode news reader."
SECTION = "console/network"
DEPENDS = "ncurses libpcre"
LICENSE = "BSD"
INC_PR = "r2"

inherit autotools 

EXTRA_OECONF = "--with-screen=ncurses --with-pcre=${STAGING_LIBDIR}/.."
