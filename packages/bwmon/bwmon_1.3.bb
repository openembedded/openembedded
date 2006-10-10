DESCRIPTION = "The Linux bandwidth monitor"
LICENSE = "GPL"
DEPENDS = "ncurses"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/bwmon/${P}.tar.gz \
           file://makefile.patch;patch=1"

inherit autotools

EXTRA_OEMAKE = "LDFLAGS=-L${STAGING_LIBDIR}"

do_install () {
        install -d ${D}${bindir}
        install ${S}/bwmon ${D}${bindir}/bwmon
}
