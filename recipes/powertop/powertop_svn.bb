require powertop.inc

SRCREV = "332"
PV = "1.12+svnr${SRCPV}"
PR = "${INC_PR}.0"

SRC_URI = "svn://powertop.googlecode.com/svn;module=trunk;proto=http"
SRC_URI_append_omap3 = " file://omap-svn.patch;patch=1"

S = "${WORKDIR}/trunk"

CFLAGS_append_omap3 = " -DOMAP3"

do_configure() {
    # We do not build ncurses with wide char support
    sed -i -e "s/lncursesw/lncurses/" ${S}/Makefile
}

