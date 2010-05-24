DESCRIPTION = "A lightweight Terminal Emulator based on libvte, written in Vala."
SECTION = "x11/applications"
DEPENDS = "vala-native vte"
SRCREV = "0241cf2f19710b885dc060d03ec80af438e8246e"
PV = "1.1.1+gitr${SRCPV}"
PE = "1"
PR = "r0"

inherit autotools

SRC_URI = "${FREESMARTPHONE_GIT}/vala-terminal.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

RDEPENDS = "ttf-liberation-mono"
RREPLACES = "openmoko-terminal2"
RPROVIDES = "openmoko-terminal2"
