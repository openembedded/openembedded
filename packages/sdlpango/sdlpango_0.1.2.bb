DESCRIPTION = "connect the text rendering engine of GNOME to SDL"
HOMEPAGE = "http://sdlpango.sourceforge.net/"
SECTION = "libs"
LICENSE = "GPL"
DEPENDS = "virtual/libsdl pango"
PR="r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/sdlpango/SDL_Pango-${PV}.tar.gz \
	   file://SDL_Pango-0.1.2-API-adds.patch;patch=1;pnum=0 \
	  "

inherit autotools

S = "${WORKDIR}/SDL_Pango-${PV}"

do_stage() {
        autotools_stage_all
}
