DESCRIPTION = "SuperTux is a classic 2D jump'n'run sidescroller game \
in a style similar to the original SuperMario games."
SECTION = "games"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r4"

APPIMAGE = "${WORKDIR}/supertux.png"
APPDESKTOP = "${WORKDIR}/supertux.desktop"

SRC_URI = "${SOURCEFORGE_MIRROR}/super-tux/supertux-${PV}.tar.bz2;name=archive \
           http://ssel.vub.ac.be/Members/DennisWagelaar/download/zaurus/supertux-0.1.2-fp.patch.gz;patch=1;name=patch \
	   file://supertux.png"

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"
EXTRA_OECONF = "--disable-opengl"

inherit autotools sdl

SRC_URI[archive.md5sum] = "7c10acf574f09ae5cb9eb2a4b9bf93ff"
SRC_URI[archive.sha256sum] = "8f2275d9667909d3418213522d5d4ef3312c158190429062f79da6b982b9ce6b"
SRC_URI[patch.md5sum] = "05787c6553316940873e8bce192a4fe0"
SRC_URI[patch.sha256sum] = "ab958a3cc04858ab72f3fe2844362f249897c3bb2149208be22da2ce5d46c9c0"
