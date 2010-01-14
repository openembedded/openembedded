DESCRIPTION = "QtWebKit Performance Utilities"
LICENSE = "GPLv3"

INC_PR = "r1"

SRC_URI = "git://gitorious.org/qtwebkit/performance.git;protocol=git"
S = "${WORKDIR}/git"
PV = "0.1+gitr${SRCREV}"

EXTRA_QMAKEVARS_PRE += "INSTALL_DIR=${bindir}"

FILES_${PN} = "${bindir}/qtwebkit-benchmark/*"
FILES_${PN}-dbg = "${bindir}/qtwebkit-benchmark/.debug/*"

do_install() {
    oe_runmake install INSTALL_ROOT=${D}
}
