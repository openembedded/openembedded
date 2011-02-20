DESCRIPTION = "Less is a program similar to more, i.e. a terminal \
based program for viewing text files and the output from other \
programs. Less offers many features beyond those that more does."
HOMEPAGE = "http://www.greenwoodsoftware.com/"
SECTION = "console/utils"
LICENSE = "BSD"
DEPENDS = "ncurses"
PR = "r1"

SRC_URI = "http://www.greenwoodsoftware.com/less/less-${PV}.tar.gz"

inherit autotools update-alternatives

do_install () {
        oe_runmake 'bindir=${D}${bindir}' 'mandir=${D}${mandir}' install
        mv ${D}${bindir}/less ${D}${bindir}/less.${PN}
}

ALTERNATIVE_NAME = "less"
ALTERNATIVE_PATH = "${bindir}/less.${PN}"
ALTERNATIVE_PRIORITY = "100"

SRC_URI[md5sum] = "817bf051953ad2dea825a1cdf460caa4"
SRC_URI[sha256sum] = "57a16ff07431a9af45cf1cd5b374e1066d019304219f0d156e22bb8c4d6734d2"

