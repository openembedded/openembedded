BROKEN = "1"
DESCRIPTION = "Dos Emulator based on SDL"
SECTION = "base"
PRIORITY = "optional"
DEPENDS = "libsdl-qpe"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/dosbox/dosbox-${PV}.tar.gz"

inherit autotools 

