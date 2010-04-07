DESCRIPTION = "A lightweight Terminal Emulator based on libvte, written in Vala."
SECTION = "x11/applications"
DEPENDS = "vala-native vte"
SRCREV = "fda5f26710acfc0befe04c8f2e58b35bdba297f7"
PV = "1.1.1+gitr${SRCREV}"
PR = "r0"

inherit autotools

SRC_URI = "${FREESMARTPHONE_GIT}/vala-terminal.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

RDEPENDS = "ttf-liberation-mono"
RREPLACES = "openmoko-terminal2"
RPROVIDES = "openmoko-terminal2"
