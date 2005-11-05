DESCRIPTION = "LBreakout2 is an award winning breakout-style arcade game in the manner of Arkanoid."
HOMEPAGE = "http://lgames.sourceforge.net/index.php?project=LBreakout2"
SECTION = "games/arcade"
LICENSE = "GPL"
MAINTAINER = "Michael 'Mickey' Lauer"
DEPENDS = "virtual/libsdl libsdl-mixer libsdl-net"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/lgames/lbreakout2-2.6beta.tar.gz"

inherit autotools

