DESCRIPTION = "SuperTux is a classic 2D jump'n'run sidescroller game \
in a style similar to the original SuperMario games."
SECTION = "games"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r1"

APPIMAGE = "${WORKDIR}/supertux.png"
APPDESKTOP = "${WORKDIR}/supertux.desktop"

SRC_URI = "${SOURCEFORGE_MIRROR}/super-tux/supertux-${PV}.tar.bz2 \
#           http://ssel.vub.ac.be/Members/DennisWagelaar/download/zaurus/supertux-0.1.2-fp.patch.gz;patch=1 \
	   file://supertux.png \
	   file://supertux.desktop \
	   "

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"
EXTRA_OECONF = "--disable-opengl"

inherit autotools sdl

DEFAULT_PREFERENCE = "-1"

SRC_URI[md5sum] = "f2fc288459f33d5cd8f645fbca737a63"
SRC_URI[sha256sum] = "0092588351776626955339caaa62d12ce5954bb80c5f6952f60a122f53c2ad97"
