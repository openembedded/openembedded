DESCRIPTION = "Forward a serial using TCP/IP"
AUTHOR = "Holger 'Zecke' Freyther'"
LICENSE = "GPL"
SECTION = "console/devel"
PV = "1.0.1+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/cornucopia.git/;protocol=git"
S = "${WORKDIR}/git/tools/serial_forward"

do_compile() {
    cd ${S}
    oe_runmake
}

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${S}/forward ${D}/${bindir}/${PN}
}
