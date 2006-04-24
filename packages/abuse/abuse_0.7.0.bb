DESCRIPTION = "Abuse-SDL is a port of Abuse by Crack Dot Com to Linux using the Simple DirectMedia Layer library."
SECTION = "games"
LICENSE = "GPL"
DEPENDS = "virtual/libsdl libsdl-mixer libsdl-image"
APPNAME = "abuse.sdl"

SRC_URI = "http://www.labyrinth.net.au/~trandor/abuse/files/abuse_sdl-${PV}.tar.bz2"
S = "${WORKDIR}/abuse_sdl-${PV}"

inherit autotools sdl

FILES_${PN} += "${datadir}/games"
