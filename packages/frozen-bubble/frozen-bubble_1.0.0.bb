LICENSE = GPL
SECTION = "games"
DEPENDS = "libsdl-mixer libsdl-image sdl-perl"

SRC_URI = "http://zarb.org/~gc/fb//frozen-bubble-${PV}.tar.bz2 \
	file://Makefile_top.patch;patch=1 \
	file://Makefile.patch;patch=1 \
	file://Makefile.PL.patch;patch=1"
# The Makefile needs to be patched to look in STAGING_LIBDIR/perl/... - It's looking in i686-linux/lib at the moment, regardless of arch
BROKEN = "1"


do_compile() {
	oe_runmake OPTIMIZE="${CFLAGS}" PREFIX="${prefix}"
}

do_install() {
	oe_runmake PREFIX="${D}${prefix}" install
}
