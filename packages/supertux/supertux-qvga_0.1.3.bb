DESCRIPTION = "SuperTux is a classic 2D jump'n'run sidescroller game \
in a style similar to the original SuperMario games (QVGA, size-optimized version)"
SECTION = "games"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "libsdl-gfx imagemagick-native pngcrush-native"
PR = "r0.20"

APPIMAGE = "${WORKDIR}/supertux.png"
APPDESKTOP = "${WORKDIR}/supertux.desktop"

PACKAGES_prepend = " ${PN}-levels-bonus1 ${PN}-levels-bonus2 "

SRC_URI = "${SOURCEFORGE_MIRROR}/super-tux/supertux-${PV}.tar.bz2 \
#           file://supertux-qvga-gfx.tar.bz2 \
           file://supertux-smallsize-data.tar.bz2 \
	   file://gp2x.patch;patch=1 \
	   file://img-resize.sh \
	   file://supertux.png \
	   file://supertux.desktop \
#	   file://letters-black.png \
#	   file://letters-blue.png \
#	   file://letters-gold.png \
#	   file://mousecursor.png \
#	   file://credits.mod \
	   "
S = "${WORKDIR}/supertux-${PV}"

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"
EXTRA_OECONF = "--enable-320x240 --disable-opengl"

inherit autotools sdl

do_compile_prepend() {
#    for f in letters-black.png letters-blue.png letters-gold.png mousecursor.png; do
#	cp ${WORKDIR}/$f ${S}/data/images/status/
#    done
    for d in background shared tilesets title worldmap; do
	cd ${S}/data/images/$d
	sh ${WORKDIR}/img-resize.sh
    done
}

do_install_prepend() {
    # *-fast.* music plays when time for a level is running out
    # byte-wise, it's the same file with few bytes changes (for .mod's). 
    # Well, seller feature, what to say, but we won't waste megabytes on 
    # that. Folks should learn to control tempo in there player lib.
    rm -f ${S}/data/music/*-fast.*
    # ogg is too heavy for embedded systems
    rm -f ${S}/data/music/*.ogg
#    cp ${WORKDIR}/*.mod ${S}/data/music/
}

FILES_${PN}-levels-bonus1 = "${datadir}/supertux/levels/bonus1 ${datadir}/supertux/levels/worldmaps/bonusisland1.stwm"
FILES_${PN}-levels-bonus2 = "${datadir}/supertux/levels/bonus2 ${datadir}/supertux/levels/worldmaps/bonusisland2.stwm"
FILES_${PN} += "${datadir}/supertux"
