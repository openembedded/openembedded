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


SRC_URI[md5sum] = "15ee44094e6a4e2a4f5f9b661f3fb617"
SRC_URI[sha256sum] = "5db9cff3fe39007e9a80c3b27acfb86692641f2b0de118ef1d5e24ebd35d438b"
