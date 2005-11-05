DESCRIPTION = "Dos Emulator based on SDL"
SECTION = "base"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/dosbox/dosbox-${PV}.tar.gz \
	file://nocdrom.patch;patch=1"
CXXFLAGS_append = " -DC_SDL_NOCDROM"

inherit autotools 

