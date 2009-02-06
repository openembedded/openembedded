DESCRIPTION = "Receive a forwarded serial from serial-forward and provide a PTY"
AUTHOR = "Holger 'Zecke' Freyther"
LICENSE = "GPL"
SECTION = "console/network"
PV = "1.0.0+svnr${SRCREV}""
PR = "r0"

SRC_URI = "svn://svn.openmoko.org/developers/zecke/;module=serial_forward;proto=http"
S = "${WORKDIR}/serial_forward"

inherit native

do_compile() {
    cd ${S}
    oe_runmake
}

do_stage() {
    :
}

do_deploy() {
    install -d ${DEPLOY_DIR_IMAGE}
    install -m 0755 ${S}/pty_forward ${DEPLOY_DIR_IMAGE}/pty-forward
}

addtask deploy before do_package after do_install
