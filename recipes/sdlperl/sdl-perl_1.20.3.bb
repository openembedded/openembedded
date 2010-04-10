DESCRIPTION = "Perl bindings for SDL"
SECTION = "libs"
HOMEPAGE = "http://sdl.perl.org/"
LICENSE = "GPL"
DEPENDS = "perl virtual/libsdl libsdl-image libsdl-gfx libsdl-ttf libsdl-mixer libsdl-net smpeg"
PR = "r2"

SRC_URI = "http://bloodgate.com/perl/sdl/pub/SDL_perl-${PV}.tar.gz"
S = "${WORKDIR}/SDL_perl-${PV}"

inherit cpan

do_configure_prepend() {
        # Search staging area for includes
        sed -i -e 's:/usr/\(local/\)\{0,1\}include:${STAGING_INCDIR}:g' Makefile.linux
}

SRC_URI[md5sum] = "ab7fb92a1ed0db54a88839e64b9ce2c6"
SRC_URI[sha256sum] = "ac6f511404457592b88fd57c4c77f7feba8e3b55d62c3c45c117fe84f1e07a7d"
