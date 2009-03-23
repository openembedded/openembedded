DESCRIPTION = "DGen/SDL is a Sega Genesis/Mega-drive emulator."
DEPENDS = "virtual/libsdl"
SECTION = "x11/games"
LICENSE = "BSD"

SRC_URI = "\
  http://pknet.com/~joe/${PN}-${PV}.tar.gz \
  file://fix-configure-and-make.patch;patch=1 \
"

inherit autotools

EXTRA_OECONF = " --disable-sdltest --without-x --without-opengl --without-nasm --without-mmx --without-star"

do_compile () {
	oe_runmake 'HOSTCC=${BUILD_CC}'
}
