DESCRIPTION = "Less is a program similar to more, i.e. a terminal \
based program for viewing text files and the output from other \
programs. Less offers many features beyond those that more does."
HOMEPAGE = "http://www.greenwoodsoftware.com/"
SECTION = "console/utils"
LICENSE = "BSD"
DEPENDS = "ncurses"

SRC_URI = "${GNU_MIRROR}/less/less-${PV}.tar.gz"

inherit autotools update-alternatives

do_install () {
        oe_runmake 'bindir=${D}${bindir}' 'mandir=${D}${mandir}' install
        mv ${D}${bindir}/less ${D}${bindir}/less.${PN}
}

ALTERNATIVE_NAME = "less"
ALTERNATIVE_PATH = "less.${PN}"
ALTERNATIVE_PRIORITY = "100"

SRC_URI[md5sum] = "b5864d76c54ddf4627fd57ab333c88b4"
SRC_URI[sha256sum] = "f532fcd61b012379d3258196a8588fd9d51ecdfb5c795485ab2f78d439b103b4"
