DESCRIPTION = "A portable C++ GUI library designed for games using Allegro, HGE, OpenGL, OpenLayer and/or SDL."
HOMEPAGE = "http://guichan.sourceforge.net"
DEPENDS = "virtual/libsdl libsdl-image"
PR = "r1"

SRC_URI = "http://guichan.googlecode.com/files/${PN}-${PV}.tar.gz \
           file://link-against-sdlimage.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--disable-opengl --disable-glut --disable-allegro \
                --enable-sdlimage --enable-sdl"

PACKAGES =+ "libguichan libguichan-sdl"

FILES_libguichan = "${libdir}/libguichan.so.*"
FILES_libguichan-sdl = "${libdir}/libguichan_sdl.so.*"

do_stage () {
	autotools_stage_all
}

