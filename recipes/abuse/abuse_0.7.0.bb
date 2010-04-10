DESCRIPTION = "Abuse-SDL is a port of Abuse by Crack Dot Com to Linux - SDL edition."
SECTION = "games"
LICENSE = "GPL"
APPNAME = "abuse.sdl"

SRC_URI = "http://www.labyrinth.net.au/~trandor/abuse/files/abuse_sdl-${PV}.tar.bz2"
S = "${WORKDIR}/abuse_sdl-${PV}"

inherit autotools sdl

FILES_${PN} += "${datadir}/games"

SRC_URI[md5sum] = "59ea4498886642aa975f04233cc92558"
SRC_URI[sha256sum] = "bda8a3c42733853444e1d4bee16e85990b78c2eaafc4b26e0769be2e14dab931"
