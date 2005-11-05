inherit autotools

DEFAULT_PREFERENCE = "-1"

SECTION = "x11/games"
DESCRIPTION = "DGen/SDL is a Sega Genesis/Mega-drive emulator."
DEPENDS = "virtual/libsdl"
SRC_URI = "http://pknet.com/~joe/${PN}-${PV}.tar.gz \
	   file://fix-configure-and-make.patch;patch=1"

EXTRA_OECONF = " --disable-sdltest --without-x --without-opengl --without-nasm --without-mmx --without-star"

do_compile () {
	oe_runmake 'HOSTCC=${BUILD_CC}'
}
