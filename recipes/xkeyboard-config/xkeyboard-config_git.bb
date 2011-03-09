require xkeyboard-config.inc

SRCREV = "9333b2f3f0e3f1724b7a5c04b8ffc5eafb96fefa"
SRCREV_palmpre = "a961c7b00f077e8923e32192243db46b10a702b7"
PV = "2.1+gitr${SRCPV}"
PR = "${INC_PR}.2"

SRC_URI = "git://anongit.freedesktop.org/xkeyboard-config;protocol=git;branch=master"
SRC_URI_palmpre = "git://git.shr-project.org/repo/xkeyboard-config.git;protocol=http;branch=palmpre"

PACKAGE_ARCH_palmpre = "${MACHINE_ARCH}"

S = "${WORKDIR}/git"
