DESCRIPTION = "Receive a forwarded serial from serial-forward and provide a PTY"
AUTHOR = "Holger 'Zecke' Freyther"
LICENSE = "GPL"
SECTION = "console/network"
SRCREV = "4662b55fdba528bb5b3349f83055bf236af5d63b"
PV = "1.1+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/cornucopia.git;protocol=git"
S = "${WORKDIR}/git/tools/serial_forward"

inherit autotools native

do_deploy() {
    install -d ${DEPLOY_DIR_IMAGE}
    install -m 0755 ${S}/src/pty_forward ${DEPLOY_DIR_IMAGE}/pty-forward
}

addtask deploy before do_package after do_install
