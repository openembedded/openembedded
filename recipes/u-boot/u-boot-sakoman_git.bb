require u-boot.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/u-boot-sakoman-git/"

SRCREV = ${AUTOREV}

PV = "2010.9+${PR}+git${SRCREV}"

SRC_URI = "git://www.sakoman.com/git/u-boot.git;branch=omap4-exp;protocol=git \
          "
S = "${WORKDIR}/git"

do_compile () {
    unset LDFLAGS
    unset CFLAGS
    unset CPPFLAGS
    oe_runmake all
}
