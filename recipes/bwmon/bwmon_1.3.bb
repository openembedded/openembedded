DESCRIPTION = "The Linux bandwidth monitor"
LICENSE = "GPL"
DEPENDS = "ncurses"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/bwmon/${P}.tar.gz \
           file://makefile.patch;patch=1"

inherit autotools

do_install () {
        install -d ${D}${bindir}
        install ${S}/bwmon ${D}${bindir}/bwmon
}
