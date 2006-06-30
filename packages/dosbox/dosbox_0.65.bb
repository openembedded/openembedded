DESCRIPTION = "Dos Emulator based on SDL"
SECTION = "base"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/dosbox/dosbox-${PV}.tar.gz \
           file://no-opengl.patch;patch=1"

inherit autotools 

EXTRA_OECONF_arm = "--disable-unaligned-memory --disable-opengl"
