require xkeyboard-config.inc

SRCREV = "547ae8589afb208d7b44ffe1e0ff7aba466c2ee3"
SRCREV_palmpre = "a961c7b00f077e8923e32192243db46b10a702b7"
PV = "2.0+gitr${SRCPV}"
PR = "${INC_PR}.1"

SRC_URI = "git://anongit.freedesktop.org/xkeyboard-config;protocol=git;branch=master"
SRC_URI_palmpre = "git://git.shr-project.org/repo/xkeyboard-config.git;protocol=http;branch=palmpre"

PACKAGE_ARCH_palmpre = "${MACHINE_ARCH}"

S = "${WORKDIR}/git"
