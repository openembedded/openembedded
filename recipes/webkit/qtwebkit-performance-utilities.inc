DESCRIPTION = "QtWebKit Performance Utilities"
LICENSE = "GPLv3"

INC_PR = "r0"

DEPENDS = "gd"

SRC_URI = "git://gitorious.org/qtwebkit/performance.git;protocol=git"
S = "${WORKDIR}/git"
PV = "0.1+gitr${SRCREV}"

EXTRA_QMAKEVARS_PRE = "INSTALL_DIR=${bindir}"

FILES_${PN} = "${bindir}/qtwebkit-benchmark/*"
FILES_${PN}-dbg = "${bindir}/qtwebkit-benchmark/.debug/*"

# package memusage stat
PACKAGES += "memusagestat-dbg memusagestat"
FILES_memusagestat = "${bindir}/*"
FILES_memusagestat-dbg = "${bindir}/.debug/*"


do_compile_append() {
    cd ${S}/host-tools/memusagestat
    ${CC} -o memusagestat memusagestat.c ${CFLAGS} ${CPPFLAGS} ${LDFLAGS} -lgd
}

do_install() {
    oe_runmake install INSTALL_ROOT=${D}
    cd ${S}/host-tools/memusagestat
    install -d ${D}${bindir}
    install -m 0755 memusagestat ${D}/${bindir}
}
