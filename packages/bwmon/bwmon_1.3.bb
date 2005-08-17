DESCRIPTION = "The Linux bandwidth monitor"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org"
DEPENDS = "ncurses"
LICENSE = "Unspecified"

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/bwmon/${P}.tar.gz \
	   file://makefile.patch;patch=1"
EXTRA_OEMAKE = "LDFLAGS=-L${STAGING_LIBDIR}"

inherit autotools

do_install () {
	install -d ${D}${bindir}
	install ${S}/bwmon ${D}${bindir}/bwmon
}
