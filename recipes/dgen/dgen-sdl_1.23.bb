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

SRC_URI[md5sum] = "b1896c1b21ddb152626aec2e8a157a3a"
SRC_URI[sha256sum] = "44396b3b324433187cf7082d1059cd9f519f02accddd667e627a57ff8514d436"
