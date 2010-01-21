DESCRIPTION = "Simple DirectMedia Layer mixer library."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl flac libmikmod libvorbis libmad"
LICENSE = "LGPL"

PR = "r2"

SRC_URI = "http://www.libsdl.org/projects/SDL_mixer/release/SDL_mixer-${PV}.tar.gz \
           file://fix-flac-madness.diff;patch=1"

S = "${WORKDIR}/SDL_mixer-${PV}"

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"

inherit autotools_stage

# Although we build SMPEG lets not use it as it is pointless in the embedded space.

# Add support for runtime linking with libmad so we can use that for fixed point MP3 decoding.
# Add support for runtime linking with libtremor so we can use that for fixed point OGG Vorbis decoding.

EXTRA_OECONF = "--disable-music-mp3 --enable-music-ogg --enable-music-ogg-tremor --enable-music-mp3-mad-gpl"

do_compile() {
	# Override SDL_LIBS to include a linker rpath so the linker
	# can find the correct libdl.so when it links playwave to
	# libSDL_mixer.so.
	oe_runmake SDL_LIBS="$(pkg-config sdl --libs) -Wl,-rpath-link,${STAGING_LIBDIR}"
}
