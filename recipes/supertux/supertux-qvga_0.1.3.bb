require supertux.inc

PR = "${INC_PR}.0"

DESCRIPTION += "(QVGA, size-optimized version)"
DEPENDS += "imagemagick-native pngcrush-native libsdl-gfx"

SRC_URI += " \
           file://supertux-smallsize-data.tar.bz2 \
	   file://gp2x.patch \
	   file://img-resize.sh \
	   "

S = "${WORKDIR}/supertux-${PV}"

EXTRA_OECONF += " --enable-320x240 LIBS=-L${STAGING_LIBDIR}"

do_compile_prepend() {
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
