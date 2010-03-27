DESCRIPTION = "Mini-version of emacs, from http://www.jasspa.com"
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "ncurses"

S = "${WORKDIR}/me060909"

SRC_URI = "http://www.jasspa.com/release_${PV}/jasspa-mesrc-${PV}-2.tar.gz \
           http://www.jasspa.com/release_${PV}/jasspa-memacros-${PV}.tar.gz \
           file://zaurus_make.patch;patch=1"

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

