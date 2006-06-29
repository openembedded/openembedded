DESCRIPTION = "SuperTux is a classic 2D jump'n run sidescroller game \
in a style similar to the original SuperMario games."
SECTION = "games"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl libsdl-mixer libsdl-image"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/super-tux/supertux-${PV}.tar.bz2 \
           http://ssel.vub.ac.be/Members/DennisWagelaar/download/zaurus/supertux-0.1.2-fp.patch.gz;patch=1"

export SDL_CONFIG = "${STAGING_BINDIR}/sdl-config"

inherit autotools 

# FIXME: Add .desktop file for Opie/Qtopia
