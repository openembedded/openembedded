LICENSE="GPL"
SUMMARY="Forward a serial using TCP/IP"

SRC_URI="svn://svn.openmoko.org/developers/zecke/;module=serial_forward;proto=http"
S="${WORKDIR}/serial_forward"

do_compile() {
    cd ${S}
    oe_runmake
}

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${S}/forward ${D}/${bindir}/${PN}
}
