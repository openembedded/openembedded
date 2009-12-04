
DEPENDS = "libogg libvorbis libsdl-x11"

SRC_URI = "http://downloads.xiph.org/releases/theora/libtheora-1.0alpha7.tar.gz"

S = "${WORKDIR}/libtheora-1.0alpha7"

inherit autotools pkgconfig lib_package


do_configure_append() {
        find ${S} -name Makefile | xargs sed -i -e s:'-I/usr/include':-I${STAGING_INCDIR}:g
}

do_stage() {
         autotools_stage_all
}


