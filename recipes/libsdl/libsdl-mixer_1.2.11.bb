DESCRIPTION = "Simple DirectMedia Layer mixer library."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl libmikmod libvorbis"
LICENSE = "LGPL"

SRC_URI = "http://www.libsdl.org/projects/SDL_mixer/release/SDL_mixer-${PV}.tar.gz"
S = "${WORKDIR}/SDL_mixer-${PV}"

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"

inherit autotools_stage

EXTRA_OECONF = "--disable-music-mp3"
# although we build smpeg... need to find out how
# to deal with optional dependencies

do_compile() {
	# Override SDL_LIBS to include a linker rpath so the linker
	# can find the correct libdl.so when it links playwave to
	# libSDL_mixer.so.
	oe_runmake SDL_LIBS="$(pkg-config sdl --libs) -Wl,-rpath-link,${STAGING_LIBDIR}"
}
