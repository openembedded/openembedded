DESCRIPTION = "Quake 1"
SECTION = "x11/games"
PRIORITY = "optional"
DEPENDS = "libsdl-x11 libsdl-mixer libsdl-net zlib"
MAINTAINER = "Simon Pickering <S.G.Pickering@bath.ac.uk>"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "http://mirror1.pdaXrom.org/rc9/src/quake1src.tar.bz2 \
           http://mirror1.pdaxrom.org/source/src/pak0.tar.gz \
           file://Makefile.patch;patch=1 \
           file://cl_parse.c.patch;patch=1 \
           file://vid_sdl.c.patch;patch=1 \
           file://host.c.patch;patch=1"

S = "${WORKDIR}/quake1src"

inherit autotools 

EXTRA_OEMAKE = "-e"

export CFLAG = "-DHAVE_ZLIB -DNO_DEBUG -finline-function"
export CXXFLAGS = "-DHAVE_ZLIB -DNO_DEBUG -finline-function"
export LIBS = "-L${STAGING_LIBDIR} -lz -lm -lX11 -lXext -lXau `${STAGING_BINDIR}/sdl-config --libs`"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 quake ${D}${bindir}
}

