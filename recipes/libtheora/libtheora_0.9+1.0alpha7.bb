
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



SRC_URI[md5sum] = "55ee3c6db3e0927e7918309891a8f52b"
SRC_URI[sha256sum] = "f5c7730ded0273a8615b12b46a32b800bbcb9e861e3a18aa92b1c062981a2fef"
