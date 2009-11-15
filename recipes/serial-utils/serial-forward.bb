DESCRIPTION = "Forward a serial using TCP/IP"
AUTHOR = "Holger 'Zecke' Freyther'"
LICENSE = "GPL"
SECTION = "console/devel"
PV = "1.0.1+gitr${SRCPV}"
PR = "r1"

SRC_URI = "${FREESMARTPHONE_GIT}/cornucopia.git/;protocol=git"
S = "${WORKDIR}/git/tools/serial_forward"
EXTRA_OEMAKE = "CC="${CC} ${LDFLAGS}""
do_compile() {
    cd ${S}
    oe_runmake
}

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${S}/forward ${D}/${bindir}/${PN}
}
