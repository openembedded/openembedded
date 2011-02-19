require xkeyboard-config.inc

SRCREV = "547ae8589afb208d7b44ffe1e0ff7aba466c2ee3"
PV = "2.0+gitr${SRCPV}"
PR = "${INC_PR}.0"

SRC_URI = "git://anongit.freedesktop.org/xkeyboard-config;protocol=git;branch=master"

S = "${WORKDIR}/git"
