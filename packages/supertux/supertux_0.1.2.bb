DESCRIPTION = "SuperTux is a classic 2D jump'n'run sidescroller game \
in a style similar to the original SuperMario games."
SECTION = "games"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r4"

APPIMAGE = "${WORKDIR}/supertux.png"
APPDESKTOP = "${WORKDIR}/supertux.desktop"

SRC_URI = "${SOURCEFORGE_MIRROR}/super-tux/supertux-${PV}.tar.bz2 \
           http://ssel.vub.ac.be/Members/DennisWagelaar/download/zaurus/supertux-0.1.2-fp.patch.gz;patch=1 \
	   file://supertux.png"

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"
EXTRA_OECONF = "--disable-opengl"

inherit autotools sdl
