DESCRIPTION = "LBreakout2 is an award winning breakout-style arcade game in the manner of Arkanoid."
HOMEPAGE = "http://lgames.sourceforge.net/index.php?project=LBreakout2"
SECTION = "games/arcade"
LICENSE = "GPL"
DEPENDS = "virtual/libsdl libsdl-mixer libsdl-net"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/lgames/lbreakout2-2.6beta.tar.gz"

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"

inherit autotools

