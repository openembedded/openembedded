DESCRIPTION = "An sh-compatible command language interpreter."
HOMEPAGE = "http://cnswww.cns.cwru.edu/~chet/bash/bashtop.html"
DEPENDS = "ncurses"
SECTION = "base/shell"
LICENSE = "GPL"
PROVIDES = "virtual/sh"
PR = "r2"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "${GNU_MIRROR}/bash/bash-${PV}.tar.gz \
	file://signames-mipsel.diff;patch=1"

inherit autotools

bindir = "/bin"
sbindir = "/sbin"

EXTRA_OECONF = "--with-curses"
export CC_FOR_BUILD = "${BUILD_CC}"

do_configure () {
	oe_runconf
}

# dont use update-alternatives class because since we are dealing with /bin/sh
# we need to do the remove in pkg_prerm where the /bin/sh link still points
# to something (postrm is a shell script)

ALTERNATIVE_NAME = "sh"
ALTERNATIVE_PATH = "${bindir}/bash"
ALTERNATIVE_PRIORITY = "30"
ALTERNATIVE_LINK = "${bindir}/${ALTERNATIVE_NAME}"

pkg_postinst() {
update-alternatives --install ${ALTERNATIVE_LINK} ${ALTERNATIVE_NAME} ${ALTERNATIVE_PATH} ${ALTERNATIVE_PRIORITY}
}

pkg_prerm() {
update-alternatives --remove ${ALTERNATIVE_NAME} ${ALTERNATIVE_PATH}
}
