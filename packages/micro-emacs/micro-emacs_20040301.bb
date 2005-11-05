DESCRIPTION = "Mini-version of emacs, from http://www.jasspa.com"
SECTION = "console/utils"
PRIORITY = "optional"
MAINTAINER = "Jason Haslup <openembedded@haslup.com>"
LICENSE = "GPL"
DEPENDS = "ncurses"

S = "${WORKDIR}/me040301"

SRC_URI = "http://www.jasspa.com/release_040301/jasspa-mesrc-20040301.tar.gz \
           http://www.jasspa.com/release_040301/jasspa-memacros-20040301.tar.gz \
           file://${FILESDIR}/zaurus_make.patch;patch=1"

do_compile () {
        oe_runmake -C src -f zaurus.gmk mec
}

do_install() {
        install -d ${D}${bindir}
        install -d ${D}${datadir}/jasspa/macros
        install -m 0755 src/mec ${D}${bindir}/mec
        install -m 0644 ${WORKDIR}/*.* ${D}${datadir}/jasspa/macros/
}

PACKAGES += " ${PN}-macros"
FILES_${PN}-macros = "${datadir}/jasspa"

