DESCRIPTION = "A game where you have to climb a tower and avoid different obstacles."
SECTION = "games"
PRIORITY = "optional"
DEPENDS = "zlib virtual/libsdl libsdl-mixer"
LICENSE = "GPL"

PR = "r0"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/toppler/toppler-${PV}.tar.gz \
  "

inherit autotools

EXTRA_OECONF = "--disable-sdltest"

