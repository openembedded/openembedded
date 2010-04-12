DESCRIPTION = "Mini-version of emacs, from http://www.jasspa.com"
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "ncurses"

S = "${WORKDIR}/me060909"

SRC_URI = "http://www.jasspa.com/release_${PV}/jasspa-mesrc-${PV}-2.tar.gz;name=archive \
           http://www.jasspa.com/release_${PV}/jasspa-memacros-${PV}.tar.gz;name=macros \
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


SRC_URI[archive.md5sum] = "6606ec40da39352e5cbb644090a13820"
SRC_URI[archive.sha256sum] = "2cb80e403a1c76c6a3405ccbf67e457e2f558e19f80c96baa608635f3e917299"
SRC_URI[macros.md5sum] = "d4d7f84744fedb933bcc408734940f0a"
SRC_URI[macros.sha256sum] = "0d5ac080cafe6ad08e4b8eda0c85df48950c0cd3056c9f8896b1474172616b12"
