SECTION = "libs"
DESCRIPTION = "Perl bindings for SDL"
SRC_URI = "http://bloodgate.com/perl/sdl/pub/SDL_perl-${PV}.tar.gz \
	file://Makefile.patch;patch=1;pnum=0"
S = "${WORKDIR}/SDL_perl-${PV}"
LICENSE = "GPL"
DEPENDS = "perl virtual/libsdl libsdl-image libsdl-gfx libsdl-ttf libsdl-mixer libsdl-net smpeg"

inherit sdl

do_stage () {
	install -d ${STAGING_LIBDIR}/perl5/vendor_perl
	install -m 0644 ${S}/lib/SDL.pm ${STAGING_LIBDIR}/perl5/vendor_perl
}
