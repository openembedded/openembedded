DESCRIPTION = "Forward a serial using TCP/IP"
AUTHOR = "Holger 'Zecke' Freyther'"
LICENSE = "GPL"
SECTION = "console/devel"
PV = "1.0.0+svnr${SRCREV}"
PR = "r0"

SRC_URI = "svn://svn.openmoko.org/developers/zecke/;module=serial_forward;proto=http"
S = "${WORKDIR}/serial_forward"

do_compile() {
    cd ${S}
    oe_runmake
}

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${S}/forward ${D}/${bindir}/${PN}
}
