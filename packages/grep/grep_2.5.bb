LICENSE = GPL
SECTION = "console/utils"
DESCRIPTION = "grep GNU utility"
MAINTAINER = "Pawel Osiczko <p.osiczko@tetrapyloctomy.org>"

SRC_URI = "${GNU_MIRROR}/grep/grep-${PV}.tar.bz2 \
	   file://install.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--disable-perl-regexp --disable-ncurses"

do_configure () {
	rm -f ${S}/m4/init.m4
	autotools_do_configure
}
