
DEPENDS = "libogg libvorbis libsdl-x11"

SRC_URI = "http://downloads.xiph.org/releases/theora/libtheora-${PV}.tar.bz2"

inherit autotools lib_package


do_configure_append() {
        find ${S} -name Makefile | xargs sed -i -e s:'-I/usr/include':-I${STAGING_INCDIR}:g
}

AUTOTOOLS_STAGE_PKGCONFIG = "1"
do_stage() {
         autotools_stage_all
}


