DESCRIPTION = "Quake 1"
SECTION = "x11/games"
PRIORITY = "optional"
DEPENDS = "libsdl-x11 libsdl-mixer libsdl-net zlib libxau"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "http://mirror1.pdaXrom.org/rc9/src/quake1src.tar.bz2;name=archive \
           http://mirror1.pdaxrom.org/source/src/pak0.tar.gz;name=pak0 \
           file://Makefile.patch;patch=1 \
           file://cl_parse.c.patch;patch=1 \
           file://vid_sdl.c.patch;patch=1 \
           file://host.c.patch;patch=1"

S = "${WORKDIR}/quake1src"

inherit autotools

EXTRA_OEMAKE = "-e"

export CFLAG = "-DHAVE_ZLIB -DNO_DEBUG -finline-function"
export CXXFLAGS = "-DHAVE_ZLIB -DNO_DEBUG -finline-function"
export LIBS = "-L${STAGING_LIBDIR} -lz -lm -lX11 -lXext -lXau `${STAGING_BINDIR_CROSS}/sdl-config --libs`"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 quake ${D}${bindir}
}


SRC_URI[archive.md5sum] = "28405a79f488570bf4e2e8d453f856a0"
SRC_URI[archive.sha256sum] = "5cd896faae49268327231f299a1187a974cb85acb509fffe8a60b84693a7e3e8"
SRC_URI[pak0.md5sum] = "677c4817c156136a3042025191ed243b"
SRC_URI[pak0.sha256sum] = "3dfe058a121e5ff2d2c7675af74a7309b0048ff9fc6dd6129d2c37cef44f0105"
