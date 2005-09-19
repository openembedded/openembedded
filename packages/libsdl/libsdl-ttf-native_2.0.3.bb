include libsdl-ttf_${PV}.bb
inherit native

DEPENDS = "libsdl-native"
FILESPATH = "${FILE_DIRNAME}/libsdl-ttf-${PV}:${FILE_DIRNAME}/libsdl-ttf:${FILE_DIRNAME}/files"

EXTRA_OECONF = "--disable-sdltest --with-sdl-prefix=${STAGING_LIBDIR}/.."

export SDL_CONFIG = "${STAGING_BINDIR}/sdl-config-native"

