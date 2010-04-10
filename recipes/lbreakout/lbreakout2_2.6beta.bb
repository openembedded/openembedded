DESCRIPTION = "LBreakout2 is an award winning breakout-style arcade game in the manner of Arkanoid."
HOMEPAGE = "http://lgames.sourceforge.net/index.php?project=LBreakout2"
SECTION = "games/arcade"
LICENSE = "GPL"
DEPENDS = "virtual/libsdl libsdl-mixer libsdl-net"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/lgames/lbreakout2-2.6beta.tar.gz"

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"

inherit autotools


SRC_URI[md5sum] = "41d6e0be4654b1716b1b3f5b53abf014"
SRC_URI[sha256sum] = "3e406c76874827c236c7070c1349f8b4ee058aa664fc3066435c938bf6d5f0e8"
