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

SRC_URI[md5sum] = "85bbf9bb7b1cee0538154dadd045418c"
SRC_URI[sha256sum] = "7f75d3b97acf707c696ea126424906204ebfa07660162de925173cdd0257eba4"
